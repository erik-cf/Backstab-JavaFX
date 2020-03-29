package com.mpec.screen.login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
	 * M�todo initialize. Se debe insertar aqu� todo lo que se deba inicializar antes de mostrar la escena.
	 * Este m�todo no debe ser llamado manualmente.
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		addListeners();
	}

	/**
	 * M�todo que setea los Listeners a los controles de la escena.
	 */
	private void addListeners() {
		Platform.runLater(() -> {
			// Action Listener del bot�n
			loginButton.setOnAction(e -> {
				System.out.println("AAAAAAHHHHH!!!");
			});

			// Key Listener del panel principal de la escena.
			mainPane.setOnKeyPressed(e -> {
				// Si se pulsa el Enter
				if (e.getCode().equals(KeyCode.ENTER))
					// Activamos acci�n del bot�n Login.
					loginButton.fire();
			});
		});
	}

}
