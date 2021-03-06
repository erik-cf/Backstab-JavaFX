package com.mpec.ui.screen.content;

import java.net.URL;
import java.util.ResourceBundle;

import com.mpec.entities.Enemy;
import com.mpec.main.Constants;
import com.mpec.mongo.manager.GetTools;
import com.mpec.ui.tools.TableTools;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
/**
 * Esta clase es el controlador de la Screen que edita parametro del enemigo.
 * @author erikc
 *
 */
public class EnemyEditor implements Initializable{
	/**
	 * Controles de la Screen.
	 */
	@FXML
	TableView<Enemy> enemyTable;
	
	/**
	 * Lista de los datos de la tabla.
	 */
	ObservableList<Enemy> tableData;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Platform.runLater(() -> {
			enemyTable.setEditable(true);
			TableTools.addGameCharacterColumns(enemyTable);
			TableTools.setColumnsEqualWidth(enemyTable);
			fillTableView();
		});			
	}
	
	public void fillTableView() {
		
		Platform.runLater(() -> {
			tableData = GetTools.getCharacter(Constants.ENEMY, Enemy.class);
			enemyTable.setItems(tableData);
		});
	}
}
