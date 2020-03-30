package com.mpec.ui.screen.content;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.mpec.main.Strings;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
			// TODO Enviar a mongo creando objeto clase user
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
}
