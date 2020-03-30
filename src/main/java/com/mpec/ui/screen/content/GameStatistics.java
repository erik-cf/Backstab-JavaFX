package com.mpec.ui.screen.content;

import java.net.URL;
import java.util.ResourceBundle;

import org.bson.Document;

import com.mpec.main.Constants;
import com.mpec.main.Strings;
import com.mpec.mongo.manager.GetTools;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GameStatistics implements Initializable {
	
	@FXML
	Label nameLabel;
	
	@FXML
	Label totalGamesLabel;
	
	@FXML
	Label totalPlayersLabel;
	
	@FXML
	Label averageTimeLabel;
	
	@FXML
	Label averageDmgDealtLabel;
	
	@FXML
	Label averageDmgReceivedLabel;
	
	@FXML
	Label averageDropsPickedLabel;
	
	@FXML
	Label nameValueLabel;
	
	@FXML
	Label gamesValueLabel;
	
	@FXML
	Label playersValueLabel;
	
	@FXML
	Label averageTimeValueLabel;
	
	@FXML
	Label averageDmgDealtValueLabel;
	
	@FXML
	Label averageDmgReceivedValueLabel;
	
	@FXML
	Label averageDropsPickedValueLabel;
	
	@FXML
	Button refreshButton;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		addListeners();
		setStrings();
		getData();
	}
	
	private void setStrings() {
		nameLabel.setText(Strings.GAMENAME);
		totalGamesLabel.setText(Strings.TOTALGAMES);
		totalPlayersLabel.setText(Strings.TOTALPLAYERS);
		averageTimeLabel.setText(Strings.AVERAGETIME);
		averageDmgDealtLabel.setText(Strings.AVERAGEDMGDEALT);
		averageDmgReceivedLabel.setText(Strings.AVERAGEDMGRECEIVED);
		averageDropsPickedLabel.setText(Strings.AVERAGEDROPSPICKED);
		refreshButton.setText(Strings.REFRESHBUTTON);
	}
	
	private void getData() {
		Document doc = GetTools.getFirstDocumentAlone(Constants.GAME_STATISTICS);
		nameValueLabel.setText(doc.getString("name"));
		gamesValueLabel.setText(String.valueOf(doc.getInteger("games")));
		playersValueLabel.setText(String.valueOf(doc.getInteger("players")));
		averageTimeValueLabel.setText(String.valueOf(doc.getInteger("average_time")));
		averageDmgDealtValueLabel.setText(String.valueOf(doc.getDouble("average_player_dmg_dealt")));
		averageDmgReceivedValueLabel.setText(String.valueOf(doc.getDouble("average_player_dmg_received")));
		averageDropsPickedValueLabel.setText(String.valueOf(doc.getInteger("average_drops_picked")));
	}
	
	private void addListeners() {
		refreshButton.setOnAction(event -> {
			getData();
		});
	}

}
