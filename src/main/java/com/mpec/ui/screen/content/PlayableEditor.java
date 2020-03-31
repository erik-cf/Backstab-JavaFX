package com.mpec.ui.screen.content;

import java.net.URL;
import java.util.ResourceBundle;

import com.mpec.entities.Playable;
import com.mpec.main.Constants;
import com.mpec.mongo.manager.GetTools;
import com.mpec.ui.tools.TableTools;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

/**
 * Controlador de la screen de PlayableEditor.
 * Esta Screen servirá para visualizar y seleccionar los jugadores controlables (de momento solo hay uno) y editar sus parámetros.
 * @author erikc
 *
 */
public class PlayableEditor implements Initializable {

	/**
	 * Controles de la Screen.
	 */
	@FXML
	TableView<Playable> playableTable;
	
	/**
	 * Lista de los datos de la tabla.
	 */
	ObservableList<Playable> tableData;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Platform.runLater(() -> {
			playableTable.setEditable(true);
			TableTools.addGameCharacterColumns(playableTable);
			TableTools.setColumnsEqualWidth(playableTable);
			fillTableView();
		});			
	}
	
	public void fillTableView() {
		Platform.runLater(() -> {
			tableData = GetTools.getCharacter(Constants.MAIN_CHARACTER, Playable.class);
			playableTable.setItems(tableData);
		});
	}
}
