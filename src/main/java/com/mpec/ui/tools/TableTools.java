package com.mpec.ui.tools;

import com.mpec.entities.DropsData;
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
	
	public static void addDropsDataColumns(TableView<DropsData> table) {
		TableColumn<DropsData, String> dropsName = new TableColumn<DropsData, String>("Char Name");
		dropsName.setCellValueFactory(new PropertyValueFactory<DropsData, String>("name"));
		
		TableColumn<DropsData, Integer> dropsValue = new TableColumn<DropsData, Integer>("Value");
		dropsValue.setCellValueFactory(new PropertyValueFactory<DropsData, Integer>("value"));
		
		TableColumn<DropsData, Integer> dropsDuration = new TableColumn<DropsData, Integer>("Duration (Seconds)");
		dropsDuration.setCellValueFactory(new PropertyValueFactory<DropsData, Integer>("duration"));
		
		TableColumn<DropsData, Integer> dropsMinRange = new TableColumn<DropsData, Integer>("Min Random Range");
		dropsMinRange.setCellValueFactory(new PropertyValueFactory<DropsData, Integer>("min_range"));
		
		TableColumn<DropsData, Integer> dropsMaxRange = new TableColumn<DropsData, Integer>("Max Random Range");
		dropsMaxRange.setCellValueFactory(new PropertyValueFactory<DropsData, Integer>("max_range"));
		
		table.getColumns().setAll(dropsName, dropsValue, dropsDuration, dropsMinRange, dropsMaxRange);
	}

}
