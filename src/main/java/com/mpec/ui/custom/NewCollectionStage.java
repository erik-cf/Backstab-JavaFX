package com.mpec.ui.custom;

import com.mpec.main.Strings;
import com.mpec.mongo.manager.PostTools;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NewCollectionStage extends Stage{

	private VBox mainPanel;
	private Label newLabel;
	private TextField newTextField;
	private Button newButton;
	
	public NewCollectionStage(BaseStage stage) {
		this.initModality(Modality.APPLICATION_MODAL);
		this.initOwner(stage);
		initialize();
		modify();
		setListeners();
		addComps();
	}
	
	private void initialize() {
		mainPanel = new VBox();
		newLabel = new Label(Strings.NEWCOLLECTION);
		newTextField = new TextField();
		newButton = new Button(Strings.SENDBUTTON);
	}
	
	private void modify() {
		mainPanel.setSpacing(15);
		mainPanel.setPadding(new Insets(15));
		mainPanel.setFillWidth(false);
		mainPanel.setAlignment(Pos.CENTER);
		newLabel.setFont(new Font("Arial", 20));
		this.setWidth(250);
		this.setHeight(200);
	}	
	
	private void setListeners() {
		newButton.setOnAction(event -> {
			if(!newTextField.getText().equals("")) {
				if(PostTools.createCollection(newTextField.getText())) {
					new Alert(AlertType.INFORMATION, Strings.COLLECTIONCREATED, ButtonType.OK).show();
				}
			}else {
				new Alert(AlertType.ERROR, Strings.NOTEMPTYTEXTFIELD, ButtonType.CLOSE).show();
			}
			this.close();
		});
	}
	
	private void addComps() {
		mainPanel.getChildren().addAll(newLabel, newTextField, newButton);
		Scene scene = new Scene(mainPanel);
		this.setScene(scene);
	}
}
