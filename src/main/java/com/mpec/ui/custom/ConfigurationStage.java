package com.mpec.ui.custom;

import java.io.IOException;
import java.util.ArrayList;

import com.mpec.config.ConfigTools;
import com.mpec.main.Strings;
import com.mpec.mongo.manager.PutTools;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfigurationStage extends Stage {

	private VBox mainPanel;
	
	private Label themeLabel;
	private ChoiceBox<String> themeChoiceBox;
	
	private Label newPassword;
	private PasswordField newPasswordPassField;
	
	private Button applyButton; 
	
	private BaseStage mainStage; 
	
	public ConfigurationStage(BaseStage stage) {
		mainStage = stage;
		this.initModality(Modality.APPLICATION_MODAL);
		this.initOwner(stage);
		initialize();
		modify();
		fillChoiceBox();
		setListeners();
		addComps();
		this.setScene(new Scene(mainPanel));
	}
	
	private void initialize() {
		mainPanel = new VBox();
		themeLabel = new Label(Strings.THEMELABEL);
		themeChoiceBox = new ChoiceBox<String>();
		
		newPassword = new Label(Strings.NEWPASSWORDLABEL);
		newPasswordPassField = new PasswordField();
		
		applyButton = new Button(Strings.APPLYBUTTON);
	}
	
	private void modify() {
		this.setWidth(300);
		this.setHeight(320);
		mainPanel.setSpacing(15);
		mainPanel.setPadding(new Insets(20));
		mainPanel.setFillWidth(false);
		mainPanel.setAlignment(Pos.CENTER);
		themeLabel.setFont(new Font("Arial", 20));
		newPassword.setFont(new Font("Arial", 20));
		
	}
	
	private void fillChoiceBox() {
		ArrayList<String> dataAL = new ArrayList<String>();
		dataAL.add(Strings.DARKCHOICE);
		dataAL.add(Strings.LIGHTCHOICE);
		themeChoiceBox.setItems(FXCollections.observableArrayList(dataAL));
	}
	
	private void setListeners() {
		applyButton.setOnAction(event -> {
			if(!themeChoiceBox.getSelectionModel().isEmpty()) {
				try {
					if(themeChoiceBox.getSelectionModel().getSelectedItem().equals(Strings.DARKCHOICE))
						ConfigTools.writeConfig("mode", "dark");
					else
						ConfigTools.writeConfig("mode", "light");
					mainStage.rebootApp();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(!newPasswordPassField.getText().equals("")) {
				PutTools.changePassword(newPasswordPassField.getText());
			}
			this.close();
		});
	}
	
	private void addComps() {
		mainPanel.getChildren().addAll(themeLabel, themeChoiceBox, newPassword, newPasswordPassField, applyButton);
	}
	
}
