package com.mpec.main;

import java.net.URL;
import java.net.URLConnection;

import com.mpec.encription.AsymmetricTools;
import com.mpec.mongo.connection.MongoConnection;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		if (!checkInternetConnection()) {
			Alert a = new Alert(AlertType.ERROR,
					Strings.NONETWORKALERT, ButtonType.CLOSE);
			a.setTitle(Strings.NONETWORKTITLE);

			a.showAndWait();

			System.exit(0);
		}
		new Thread(() -> {
			MongoConnection.initialize();
		}).start();

		try {
			Parent root = FXMLLoader.load(getClass().getResource("../ui/fxml/login/login_fxml.fxml"));
			Scene scene = new Scene(root, 600, 400);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		AsymmetricTools.initialize();
		Constants.initializeProperties();
		launch(args);
	}

	private static boolean checkInternetConnection() {
		try {
			URL url = new URL("https://www.google.es");
			URLConnection conn = url.openConnection();
			conn.getInputStream().close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
