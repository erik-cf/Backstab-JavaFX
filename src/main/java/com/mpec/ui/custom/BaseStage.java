package com.mpec.ui.custom;

import java.io.IOException;

import com.mpec.entities.User;
import com.mpec.main.Constants;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BaseStage extends Stage {
	
	private BorderPane root;
	private ApplicationMenuBar menuBar;
	
	public BaseStage(User loggedUser) {
		Constants.loggedUser = loggedUser;
		this.setWidth(Constants.WINDOW_BASE_WIDTH);
		this.setHeight(Constants.WINDOW_BASE_HEIGHT);
		root = new BorderPane();
		Parent sideBar = null;
		menuBar = new ApplicationMenuBar(root);
		try {
			sideBar = FXMLLoader.load(getClass().getResource("../fxml/app/SideMenu.fxml"));
		} catch (IOException e) {
			new Alert(AlertType.ERROR, "No FXML found for SideBar").show();
		}
		ApplicationBorderPane appBorderPane = new ApplicationBorderPane(sideBar, null);
		root.setCenter(appBorderPane);
		root.setTop(menuBar);
		this.setScene(new Scene(root));
	}
	
}
