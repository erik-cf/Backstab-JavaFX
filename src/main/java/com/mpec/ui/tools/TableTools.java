package com.mpec.ui.tools;

import com.mpec.entities.GameCharacter;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableTools {
	public static <T> void setColumnsEqualWidth(TableView<T> tv) {
		for(TableColumn<T, ?> column : tv.getColumns()) {
			column.setPrefWidth(tv.getPrefWidth() / tv.getColumns().size() - 0.5);
		}
	}
	
	public static <T> void addGameCharacterColumns(TableView<T> table) {
		TableColumn<T, String> characterName = new TableColumn<T, String>("Char Name");
		characterName.setCellValueFactory(new PropertyValueFactory<T, String>("name"));
		
		TableColumn<T, Double> characterAttack = new TableColumn<T, Double>("Attack");
		characterAttack.setCellValueFactory(new PropertyValueFactory<T, Double>("attack"));
		
		TableColumn<T, Double> characterDefense = new TableColumn<T, Double>("Defense");
		characterDefense.setCellValueFactory(new PropertyValueFactory<T, Double>("defense"));
		
		TableColumn<T, Double> characterHp = new TableColumn<T, Double>("HP");
		characterHp.setCellValueFactory(new PropertyValueFactory<T, Double>("hp"));
		
		TableColumn<T, Double> characterMovementSpeed = new TableColumn<T, Double>("Movement Speed");
		characterMovementSpeed.setCellValueFactory(new PropertyValueFactory<T, Double>("movement_speed"));
		
		TableColumn<T, Double> characterAttackSpeed = new TableColumn<T, Double>("Attack Speed");
		characterAttackSpeed.setCellValueFactory(new PropertyValueFactory<T, Double>("attack_speed"));
		
		TableColumn<T, Double> characterRange = new TableColumn<T, Double>("Range");
		characterRange.setCellValueFactory(new PropertyValueFactory<T, Double>("range"));
		
		table.getColumns().setAll(characterName, characterAttack, characterDefense, characterHp, characterMovementSpeed, characterAttackSpeed, characterRange);
	}

}
