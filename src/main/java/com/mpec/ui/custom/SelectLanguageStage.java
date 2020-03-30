package com.mpec.ui.custom;

import java.io.IOException;

import com.mpec.config.ConfigTools;
import com.mpec.main.Strings;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SelectLanguageStage extends Stage {

	VBox vBox;
	ChoiceBox<String> selectLanguage;
	Button submitButton;
	BaseStage mainStage;
	
	public SelectLanguageStage(BaseStage mainStage) {
		this.mainStage = mainStage;
		this.initModality(Modality.WINDOW_MODAL);
		this.initOwner(mainStage);
		initialize();
		modify();
		fillChoiceBox();
		setListeners();
		addToPane();
		this.setScene(new Scene(vBox));
		this.setWidth(400);
		this.setHeight(200);
	}
	
	private void initialize() {
		vBox = new VBox();
		selectLanguage = new ChoiceBox<String>();
		submitButton = new Button(Strings.SENDBUTTON);
	}
	
	private void modify() {
		vBox.setSpacing(20);
		vBox.setAlignment(Pos.CENTER);
	}
	
	private void setListeners() {
		submitButton.setOnAction(event -> {
			if(selectLanguage.getSelectionModel().isEmpty()) {
				new Alert(AlertType.ERROR, Strings.NOTEMPTYCHOICEBOX, ButtonType.CLOSE).show();
				return;
			}
			try {
				ConfigTools.writeConfig(ConfigTools.LANGUAGE, selectLanguage.getSelectionModel().getSelectedItem());
			} catch (IOException e) {
				e.printStackTrace();
			}
			mainStage.rebootApp();
			this.close();
		});
	}
	
	private void fillChoiceBox() {
		ObservableList<String> data = FXCollections.observableArrayList("English","Español");
		selectLanguage.setItems(data);
	}
	
	private void addToPane() {
		vBox.getChildren().addAll(selectLanguage, submitButton);
	}
}
