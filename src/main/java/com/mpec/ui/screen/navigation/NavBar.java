package com.mpec.ui.screen.navigation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.mpec.main.Constants;
import com.mpec.main.Strings;
import com.mpec.ui.custom.BaseStage;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Label;

public class NavBar implements Initializable {
	
	@FXML
	Label editStats;
	
	@FXML
	Label playableEditor;
	
	@FXML
	Label enemyEditor;
	
	@FXML
	Label mapEditor;
	
	@FXML
	Label dropsDataEditor;
	
	@FXML
	Label gameInfo;
	
	@FXML
	Label gameStatistics;
	
	@FXML
	Label users;
	
	@FXML
	Label userSearch;
	
	@FXML
	Label newUser;
	
	BaseStage stage;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Platform.runLater(() -> {
			Constants.selectedLabel = playableEditor;
			setStrings();
			stage = (BaseStage)newUser.getScene().getWindow();
			addListeners();	
		});
	}
	
	private void addListeners() {
		playableEditor.setOnMouseEntered(event -> {
			playableEditor.setCursor(Cursor.HAND);
		});
		playableEditor.setOnMouseClicked(event -> {
			Constants.selectedLabel = playableEditor;
			try {
				stage.changeContentScene(FXMLLoader.load(getClass().getResource("../../fxml/app/CharacterEditor.fxml")));
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		enemyEditor.setOnMouseEntered(event -> {
			enemyEditor.setCursor(Cursor.HAND);
		});
		enemyEditor.setOnMouseClicked(event -> {
			Constants.selectedLabel = enemyEditor;
			try {
				stage.changeContentScene(FXMLLoader.load(getClass().getResource("../../fxml/app/EnemyEditor.fxml")));
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		mapEditor.setOnMouseEntered(event -> {
			mapEditor.setCursor(Cursor.HAND);
		});
		mapEditor.setOnMouseClicked(event -> {
			Constants.selectedLabel = mapEditor;
			try {
				stage.changeContentScene(FXMLLoader.load(getClass().getResource("../../fxml/app/MapEditor.fxml")));
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		dropsDataEditor.setOnMouseEntered(event -> {
			dropsDataEditor.setCursor(Cursor.HAND);
		});
		dropsDataEditor.setOnMouseClicked(event -> {
			Constants.selectedLabel = dropsDataEditor;
			try {
				stage.changeContentScene(FXMLLoader.load(getClass().getResource("../../fxml/app/DropsDataEditor.fxml")));
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		gameStatistics.setOnMouseEntered(event -> {
			gameStatistics.setCursor(Cursor.HAND);
		});
		gameStatistics.setOnMouseClicked(event -> {
			Constants.selectedLabel = gameStatistics;
			// TODO add game statistics scene
		});
		
		userSearch.setOnMouseEntered(event -> {
			userSearch.setCursor(Cursor.HAND);
		});
		userSearch.setOnMouseClicked(event -> {
			Constants.selectedLabel = userSearch;
			// TODO add user search scene
		});
		
		newUser.setOnMouseEntered(event -> {
			newUser.setCursor(Cursor.HAND);
		});
		newUser.setOnMouseClicked(event -> {
			Constants.selectedLabel = newUser;
			// TODO add new User scene
		});
	}
	
	private void setStrings() {
		editStats.setText(Strings.EDITSTATSNAV);
		playableEditor.setText(Strings.CHARACTERNAV);
		enemyEditor.setText(Strings.ENEMYNAV);
		mapEditor.setText(Strings.MAPNAV);
		dropsDataEditor.setText(Strings.DROPSDATANAV);
		gameInfo.setText(Strings.GAMEINFONAV);
		gameStatistics.setText(Strings.GAMESTATISTICSNAV);
		users.setText(Strings.USERSNAV);
		userSearch.setText(Strings.SEARCHUSERNAV);
		newUser.setText(Strings.NEWUSERNAV);
	}

}
