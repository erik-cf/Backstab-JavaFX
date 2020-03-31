package com.mpec.ui.screen.content;

import java.net.URL;
import java.util.ResourceBundle;

import org.bson.Document;

import com.mpec.entities.Map;
import com.mpec.main.Constants;
import com.mpec.main.Strings;
import com.mpec.mongo.manager.GetTools;
import com.mpec.mongo.manager.PutTools;
import com.mpec.ui.tools.Validation;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;

public class MapEditor implements Initializable {

	@FXML
	Label phaseLabel;

	@FXML
	Label minDropLabel;

	@FXML
	Label maxDropLabel;

	@FXML
	Label baseMonstersLabel;

	@FXML
	Label collisionLabel;

	@FXML
	TextField phaseTextField;

	@FXML
	TextField minDropTextField;

	@FXML
	TextField maxDropTextField;

	@FXML
	TextField baseMonstersTextField;

	@FXML
	TextField collisionProbabilityTextField;

	@FXML
	Button applyButton;

	@FXML
	HBox mainPane;
	
	Map oldGameParams;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setStrings();
		addListeners();
		fillTextFields();
		getOldParams();
	}

	public void addListeners() {

		applyButton.setOnAction(event -> {
			if (!Validation.validateInteger(phaseTextField.getText())
					|| !Validation.validateInteger(minDropTextField.getText())
					|| !Validation.validateInteger(maxDropTextField.getText())
					|| !Validation.validateInteger(baseMonstersTextField.getText())
					|| !Validation.validateInteger(collisionProbabilityTextField.getText())) {
				new Alert(AlertType.ERROR, Strings.ONLYINTEGERS, ButtonType.CLOSE).show();
				return;
			}

			Map gameParams = new Map(Integer.parseInt(phaseTextField.getText()),
					Integer.parseInt(minDropTextField.getText()), Integer.parseInt(maxDropTextField.getText()),
					Integer.parseInt(baseMonstersTextField.getText()), Integer.parseInt(collisionProbabilityTextField.getText()));
			PutTools.updateGameParams(gameParams, oldGameParams);
			oldGameParams = new Map(Integer.parseInt(phaseTextField.getText()),
					Integer.parseInt(minDropTextField.getText()), Integer.parseInt(maxDropTextField.getText()),
					Integer.parseInt(baseMonstersTextField.getText()), Integer.parseInt(collisionProbabilityTextField.getText()));
			new Alert(AlertType.INFORMATION, Strings.CHANGESAPPLIED, ButtonType.OK).show();
		});
		mainPane.setOnKeyPressed(event -> {
			if (event.getCode().equals(KeyCode.ENTER)) {
				applyButton.arm();
			}
		});
		mainPane.setOnKeyReleased(event -> {
			if (event.getCode().equals(KeyCode.ENTER)) {
				applyButton.fire();
				applyButton.disarm();
			}
		});
	}

	public void fillTextFields() {
		Document doc = GetTools.getFirstDocumentAlone(Constants.GAME_PARAMS);
		phaseTextField.setText(String.valueOf(doc.getInteger("phase_time")));
		minDropTextField.setText(String.valueOf(doc.getInteger("min_drop_time")));
		maxDropTextField.setText(String.valueOf(doc.getInteger("max_drop_time")));
		baseMonstersTextField.setText(String.valueOf(doc.getInteger("base_monsters_count")));
		collisionProbabilityTextField.setText(String.valueOf(doc.getInteger("collision_probability")));
	}

	private void setStrings() {
		phaseLabel.setText(Strings.PHASETIME);
		minDropLabel.setText(Strings.MINDROPTIME);
		maxDropLabel.setText(Strings.MAXDROPTIME);
		baseMonstersLabel.setText(Strings.MONSTERSCOUNT);
		collisionLabel.setText(Strings.COLLISIONPROB);
		applyButton.setText(Strings.APPLYBUTTON);
	}
	
	private void getOldParams() {
		oldGameParams = new Map(Integer.parseInt(phaseTextField.getText()),
				Integer.parseInt(minDropTextField.getText()), Integer.parseInt(maxDropTextField.getText()),
				Integer.parseInt(baseMonstersTextField.getText()), Integer.parseInt(collisionProbabilityTextField.getText()));
	}
}
