package com.mpec.ui.custom;

import java.io.IOException;

import com.mpec.config.ConfigTools;
import com.mpec.entities.User;
import com.mpec.main.Constants;
import com.mpec.main.Strings;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BaseStage extends Stage {
	
	private BorderPane root;
	private ApplicationMenuBar menuBar;
	ApplicationBorderPane appBorderPane;
	private VBox sideBar;
	
	public BaseStage(User loggedUser) {
		try {
			Constants.language = ConfigTools.readConfig(ConfigTools.LANGUAGE);
			Constants.mode = ConfigTools.readConfig(ConfigTools.MODE);
			Strings.loadStrings();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Constants.loggedUser = loggedUser;
		this.setWidth(Constants.WINDOW_BASE_WIDTH);
		this.setHeight(Constants.WINDOW_BASE_HEIGHT);
		root = new BorderPane();
		sideBar = null;
		menuBar = new ApplicationMenuBar(root);
		try {
			sideBar = FXMLLoader.load(getClass().getResource("../fxml/app/SideMenu.fxml"));
		} catch (IOException e) {
			new Alert(AlertType.ERROR, "No FXML found for SideBar").show();
		}
		Parent content = null;
		try {
			content = FXMLLoader.load(getClass().getResource("../fxml/app/CharacterEditor.fxml"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		appBorderPane = new ApplicationBorderPane(sideBar, content);
		root.setCenter(appBorderPane);
		root.setTop(menuBar);
		root.getStyleClass().add("mainpane");
		Scene mainScene = new Scene(root);
		if(Constants.mode.equals("dark"))
			mainScene.getStylesheets().add(getClass().getResource("BaseStageDark.css").toExternalForm());
		this.setScene(mainScene);
	}
	
	public void changeContentScene(Parent center) {
		appBorderPane.setCenter(center);
	}
	
	public VBox getSideBar() {
		return sideBar;
	}
	
	public Parent getContentPane() {
		return (Parent)appBorderPane.getCenter();
	}
	
	public void rebootApp() {
		new Alert(AlertType.INFORMATION, Strings.REBOOTAPP, ButtonType.CLOSE).showAndWait();
		
		new BaseStage(Constants.loggedUser).show();
		this.close();
	}
	
}
