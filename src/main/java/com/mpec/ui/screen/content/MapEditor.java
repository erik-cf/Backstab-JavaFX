package com.mpec.ui.screen.content;

import java.net.URL;
import java.util.ResourceBundle;

import org.bson.Document;

import com.mpec.main.Constants;
import com.mpec.mongo.manager.GetTools;
import com.mpec.ui.custom.BaseStage;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;

public class MapEditor implements Initializable {

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
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
			addListeners();
			fillTextFields();
	}
	
	public void addListeners() {
		
			applyButton.setOnAction(event -> {
				System.out.println("eeeeeee");
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
}
