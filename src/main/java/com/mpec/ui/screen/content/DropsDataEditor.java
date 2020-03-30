package com.mpec.ui.screen.content;

import java.net.URL;
import java.util.ResourceBundle;

import com.mpec.entities.DropsData;
import com.mpec.main.Strings;
import com.mpec.mongo.manager.GetTools;
import com.mpec.ui.tools.TableTools;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class DropsDataEditor implements Initializable{
	/**
	 * Controles de la Screen.
	 */
	@FXML
	TableView<DropsData> dropsDataTable;
	
	@FXML
	Button editButton;
	
	/**
	 * Lista de los datos de la tabla.
	 */
	ObservableList<DropsData> tableData;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Platform.runLater(() -> {
			TableTools.addDropsDataColumns(dropsDataTable);
			TableTools.setColumnsEqualWidth(dropsDataTable);
			fillTableView();
		});			
	}
	
	public void fillTableView() {
		Platform.runLater(() -> {
			editButton.setText(Strings.EDITBUTTON);
			tableData = GetTools.getDropsData();
			dropsDataTable.setItems(tableData);
		});
	}
}
