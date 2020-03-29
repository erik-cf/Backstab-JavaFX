package com.mpec.screen.login;

import java.net.URL;
import java.util.ResourceBundle;

import com.mpec.mongo.manager.GetTools;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;

public class LoginScreenController implements Initializable {

	/**
	 * Controles del FXML de la pantalla de Login
	 */
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
		addListeners();
	}

	/**
	 * Método que setea los Listeners a los controles de la escena.
	 */
	private void addListeners() {
		Platform.runLater(() -> {
			// Action Listener del botón
			loginButton.setOnAction(event -> {
				if(GetTools.validateLogin(userTextField.getText(), passPasswordField.getText())) {
					new Alert(AlertType.ERROR, "OK", ButtonType.CLOSE).showAndWait();
				}else {
					new Alert(AlertType.ERROR, "Invalid username or password!", ButtonType.CLOSE).showAndWait();
				}
			});

			// Key Listener del panel principal de la escena.
			mainPane.setOnKeyPressed(event -> {
				// Si se pulsa el Enter
				if (event.getCode().equals(KeyCode.ENTER))
					// Activamos acción del botón Login, armándolo para dar el efecto visual.
					loginButton.arm();
					loginButton.fire();
					loginButton.disarm();
			});
		});
	}

}
