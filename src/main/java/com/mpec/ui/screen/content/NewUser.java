package com.mpec.ui.screen.content;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.mpec.encription.HashTools;
import com.mpec.entities.User;
import com.mpec.main.Constants;
import com.mpec.main.Strings;
import com.mpec.mongo.manager.GetTools;
import com.mpec.mongo.manager.PostTools;

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class NewUser implements Initializable {

	@FXML
	Label nameLabel;

	@FXML
	TextField nameTextField;

	@FXML
	Label surnameLabel;

	@FXML
	TextField surnameTextField;

	@FXML
	Label usernameLabel;

	@FXML
	TextField usernameTextField;

	@FXML
	Label passwordLabel;

	@FXML
	PasswordField passwordPasswordField;

	@FXML
	Label mailLabel;

	@FXML
	TextField mailTextField;

	@FXML
	Label roleLabel;

	@FXML
	ChoiceBox<String> roleChoiceBox;

	ObservableList<String> data;

	@FXML
	Button sendButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setListeners();
		fillChoiceBox();
		setStrings();
	}

	private void setListeners() {
		sendButton.setOnAction(event -> {
			if (nameTextField.getText().equals("") || surnameTextField.getText().equals("")
					|| usernameTextField.getText().equals("") || passwordPasswordField.getText().equals("")
					|| mailTextField.getText().equals("") || roleChoiceBox.getSelectionModel().isEmpty()) {
				new Alert(AlertType.ERROR, Strings.FILLALLFIELDS, ButtonType.CLOSE).show();
				return;
			}
			if(GetTools.checkIfFieldExists(Constants.USER, "username", usernameTextField.getText())) {
				new Alert(AlertType.ERROR, Strings.USERNAMEEXISTS, ButtonType.CLOSE).show();
				return;
			}
			if(GetTools.checkIfEncriptedFieldExists(Constants.USER, "mail", mailTextField.getText())) {
				new Alert(AlertType.ERROR, Strings.MAILEXISTS, ButtonType.CLOSE).show();
				return;
			}
			int role;
			if(roleChoiceBox.getSelectionModel().getSelectedItem().equalsIgnoreCase(Strings.ADMINCHOICE)){
				role = 1;				
			}else {
				role = 0;
			}
			User user = new User(nameTextField.getText(), surnameTextField.getText(), mailTextField.getText(), usernameTextField.getText(), HashTools.stringToMD5(passwordPasswordField.getText()), role);
			PostTools.postUser(user);
			new Alert(AlertType.CONFIRMATION, Strings.NEWUSERADDED, ButtonType.OK).show();
			clearFields();
		});
	}

	private void fillChoiceBox() {
		ArrayList<String> roleDataAL = new ArrayList<String>();
		roleDataAL.add(Strings.ADMINCHOICE);
		roleDataAL.add(Strings.NORMALCHOICE);
		data = FXCollections.observableArrayList(roleDataAL);
		roleChoiceBox.setItems(data);
	}

	private void setStrings() {
		nameLabel.setText(Strings.NAMELABEL);
		surnameLabel.setText(Strings.SURNAMELABEL);
		usernameLabel.setText(Strings.USERNAMELABEL);
		passwordLabel.setText(Strings.PASSWORDLABEL);
		mailLabel.setText(Strings.MAILLABEL);
		roleLabel.setText(Strings.ROLELABEL);
		sendButton.setText(Strings.SENDBUTTON);
	}
	
	private void clearFields() {
		nameTextField.setText("");
		surnameTextField.setText("");
		usernameTextField.setText("");
		passwordPasswordField.setText("");
		mailTextField.setText("");
		roleChoiceBox.getSelectionModel().clearSelection();
	}
}
