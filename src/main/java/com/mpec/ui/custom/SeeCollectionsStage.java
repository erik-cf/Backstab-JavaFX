package com.mpec.ui.custom;

import com.mpec.main.Strings;
import com.mpec.mongo.manager.GetTools;
import com.mpec.mongo.manager.PutTools;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SeeCollectionsStage extends Stage {
	
	private VBox mainPanel;	
	private ListView<String> collectionsList;
	private ObservableList<String> data;
	
	public SeeCollectionsStage(BaseStage stage) {
		this.initModality(Modality.APPLICATION_MODAL);
		this.initOwner(stage);
		mainPanel = new VBox();
		collectionsList = new ListView<String>();
		data = FXCollections.observableArrayList(GetTools.listCollections());
		modify();
		setChangingListView();
		mainPanel.getChildren().add(collectionsList);
		Scene scene = new Scene(mainPanel);
		this.setScene(scene);
	}
	
	private void modify() {
		this.setWidth(300);
		this.setHeight(300);
		mainPanel.setFillWidth(true);
		collectionsList.setItems(data);		
	}
	
	private void setChangingListView() {
		collectionsList.setEditable(true);
		collectionsList.setCellFactory(TextFieldListCell.forListView());
		collectionsList.setOnEditCommit(value -> {
			String oldValue = collectionsList.getSelectionModel().getSelectedItem();
			int oldValueIndex = collectionsList.getSelectionModel().getSelectedIndex();
			if(PutTools.updateCollectionName(oldValue, value.getNewValue())) {
				collectionsList.getItems().set(oldValueIndex, value.getNewValue());
				new Alert(AlertType.INFORMATION, Strings.COLLECTIONRENAMED, ButtonType.OK).show();
			}
		});

	}
	
}
