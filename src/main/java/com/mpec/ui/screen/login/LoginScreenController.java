package com.mpec.ui.screen.login;

import java.net.URL;
import java.util.ResourceBundle;

import com.mpec.encription.HashTools;
import com.mpec.entities.User;
import com.mpec.main.Strings;
import com.mpec.mongo.manager.GetTools;
import com.mpec.ui.custom.BaseStage;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginScreenController implements Initializable {

	/**
	 * Controles del FXML de la pantalla de Login
	 */
	@FXML
	Label titleLabel;
	
	@FXML
	Label userLabel;
	
	@FXML
	Label passLabel;
	
	@FXML
	TextField userTextField;

	@FXML
	PasswordField passPasswordField;

	@FXML
	BorderPane mainPane;

	@FXML
	Button loginButton;

	/**
	 * Método initialize. Se debe insertar aquí todo lo que se deba inicializar antes de mostrar la escena.
	 * Este método no debe ser llamado manualmente.
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setStrings();
		addListeners();
	}

	/**
	 * Método que setea los Listeners a los controles de la escena.
	 */
	private void addListeners() {
		// Debemos hacer el RunLater, ya que si no, nos dará un NullPointerException ya que aún puede que no se hayan inicializado los controles de la ventana
		Platform.runLater(() -> {
			// Action Listener del botón
			loginButton.setOnAction(event -> {
				
				User enteredUser = GetTools.validateLogin(userTextField.getText(), HashTools.stringToMD5(passPasswordField.getText()));
				if(enteredUser != null) {
					
					if(enteredUser.getRole() != 1) {
						new Alert(AlertType.ERROR, "You don't have permission to use this application!", ButtonType.CLOSE).showAndWait();
						return;
					}
					// Creamos el Base Stage
					BaseStage baseStage = new BaseStage(enteredUser);
					// Lo mostramos
					baseStage.show();
					
					// Cerramos esta ventana
					((Stage)loginButton.getScene().getWindow()).close();
				}else {
					new Alert(AlertType.ERROR, "Invalid username or password!", ButtonType.CLOSE).showAndWait();
				}
			});

			// Key Listener del panel principal de la escena.
			mainPane.setOnKeyPressed(event -> {
				// Si se pulsa el Enter
				if (event.getCode().equals(KeyCode.ENTER)) {
					// Activamos acción del botón Login, armándolo para dar el efecto visual.
					loginButton.arm();
					loginButton.fire();
					loginButton.disarm();
				}
			});
		});
	}
	
	private void setStrings() {
		titleLabel.setText(Strings.LOGINTITLE);
		userLabel.setText(Strings.USERNAMELABEL);
		userTextField.setPromptText(Strings.USERNAMEFIELD);
		passLabel.setText(Strings.PASSWORDLABEL);
		passPasswordField.setPromptText(Strings.PASSWORDFIELD);
		loginButton.setText(Strings.LOGINBUTTON);
	}

}
