package com.mpec.ui.tools;

import com.mpec.entities.DropsData;
import com.mpec.entities.GameCharacter;
import com.mpec.main.Strings;

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
		TableColumn<T, String> characterName = new TableColumn<T, String>(Strings.COLUMNCHARNAME);
		characterName.setCellValueFactory(new PropertyValueFactory<T, String>("name"));
		
		TableColumn<T, Double> characterAttack = new TableColumn<T, Double>(Strings.COLUMNATTACK);
		characterAttack.setCellValueFactory(new PropertyValueFactory<T, Double>("attack"));
		
		TableColumn<T, Double> characterDefense = new TableColumn<T, Double>(Strings.COLUMNDEFENSE);
		characterDefense.setCellValueFactory(new PropertyValueFactory<T, Double>("defense"));
		
		TableColumn<T, Double> characterHp = new TableColumn<T, Double>(Strings.COLUMNHP);
		characterHp.setCellValueFactory(new PropertyValueFactory<T, Double>("hp"));
		
		TableColumn<T, Double> characterMovementSpeed = new TableColumn<T, Double>(Strings.COLUMNMOVEMENTSPEED);
		characterMovementSpeed.setCellValueFactory(new PropertyValueFactory<T, Double>("movement_speed"));
		
		TableColumn<T, Double> characterAttackSpeed = new TableColumn<T, Double>(Strings.COLUMNATTACKSPEED);
		characterAttackSpeed.setCellValueFactory(new PropertyValueFactory<T, Double>("attack_speed"));
		
		TableColumn<T, Double> characterRange = new TableColumn<T, Double>(Strings.COLUMNRANGE);
		characterRange.setCellValueFactory(new PropertyValueFactory<T, Double>("range"));
		
		table.getColumns().setAll(characterName, characterAttack, characterDefense, characterHp, characterMovementSpeed, characterAttackSpeed, characterRange);
	}
	
	public static void addDropsDataColumns(TableView<DropsData> table) {
		TableColumn<DropsData, String> dropsName = new TableColumn<DropsData, String>(Strings.COLUMNDROPNAME);
		dropsName.setCellValueFactory(new PropertyValueFactory<DropsData, String>("name"));
		
		TableColumn<DropsData, Integer> dropsValue = new TableColumn<DropsData, Integer>(Strings.COLUMNVALUE);
		dropsValue.setCellValueFactory(new PropertyValueFactory<DropsData, Integer>("value"));
		
		TableColumn<DropsData, Integer> dropsDuration = new TableColumn<DropsData, Integer>(Strings.COLUMNDURATION);
		dropsDuration.setCellValueFactory(new PropertyValueFactory<DropsData, Integer>("duration"));
		
		TableColumn<DropsData, Integer> dropsMinRange = new TableColumn<DropsData, Integer>(Strings.COLUMNMINRANGE);
		dropsMinRange.setCellValueFactory(new PropertyValueFactory<DropsData, Integer>("min_range"));
		
		TableColumn<DropsData, Integer> dropsMaxRange = new TableColumn<DropsData, Integer>(Strings.COLUMNMAXRANGE);
		dropsMaxRange.setCellValueFactory(new PropertyValueFactory<DropsData, Integer>("max_range"));
		
		table.getColumns().setAll(dropsName, dropsValue, dropsDuration, dropsMinRange, dropsMaxRange);
	}

}
