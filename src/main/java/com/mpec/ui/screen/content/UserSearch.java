package com.mpec.ui.screen.content;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.mpec.main.Strings;
import com.mpec.mongo.manager.GetTools;
import com.mpec.ui.custom.BaseStage;
import com.mpec.ui.custom.SearchUserResults;
import com.mpec.encription.AsymmetricTools;
import com.mpec.entities.User;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UserSearch implements Initializable {
	
	@FXML
	Label fieldLabel;
	
	@FXML
	ChoiceBox<String> fieldChoiceBox;
	
	ObservableList<String> data; 
	
	@FXML
	Label valueLabel;
	
	@FXML
	TextField valueTextField;
	
	@FXML
	Button searchButton;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		fillChoiceBox();
		setListeners();
		setStrings();
	}
	
	private void setStrings() {
		fieldLabel.setText(Strings.FIELDLABEL);
		valueLabel.setText(Strings.VALUELABEL);
		searchButton.setText(Strings.SEARCHBUTTON);
	}
	
	private void fillChoiceBox() {
		ArrayList<String> dataAL = new ArrayList<String>();
		dataAL.add(Strings.NAMECHOICE);
		dataAL.add(Strings.SURNAMECHOICE);
		dataAL.add(Strings.USERNAMECHOICE);
		dataAL.add(Strings.MAILCHOICE);
		data = FXCollections.observableArrayList(dataAL);
		fieldChoiceBox.setItems(data);
	}
	
	private void setListeners() {
		searchButton.setOnAction(event -> {
			if(fieldChoiceBox.getSelectionModel().isEmpty()) {
				new Alert(AlertType.ERROR, Strings.NOTEMPTYCHOICEBOX, ButtonType.CLOSE).show();
				return;
			}
			if(valueTextField.getText().equals("") || valueTextField.getText() == null) {
				new Alert(AlertType.ERROR, Strings.NOTEMPTYTEXTFIELD, ButtonType.CLOSE).show();
				return;
			}
			ObservableList<User> data = null;
			if(fieldChoiceBox.getSelectionModel().getSelectedItem().equals(Strings.NAMECHOICE)) {
				data = GetTools.getUsersResult("name", valueTextField.getText());
			}else if(fieldChoiceBox.getSelectionModel().getSelectedItem().equals(Strings.SURNAMECHOICE)) {
				data = GetTools.getUsersResult("surname", valueTextField.getText());
			}else if(fieldChoiceBox.getSelectionModel().getSelectedItem().equals(Strings.USERNAMECHOICE)) {
				data = GetTools.getUsersResult("username", valueTextField.getText());
			}else if(fieldChoiceBox.getSelectionModel().getSelectedItem().equals(Strings.MAILCHOICE)) {
				try {
					data = GetTools.getUsersResult("mail", AsymmetricTools.encryptText(valueTextField.getText()));
				} catch (Exception e) {
					e.printStackTrace();
				}			
			}else {
				new Alert(AlertType.ERROR, "Unknown Error...", ButtonType.CLOSE).show();
				return;
			}
			SearchUserResults searchResults = new SearchUserResults(((BaseStage)searchButton.getScene().getWindow()), data);
			searchResults.show();
		});
	}
}
