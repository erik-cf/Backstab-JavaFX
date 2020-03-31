package com.mpec.ui.tools;

import com.mpec.entities.DropsData;
import com.mpec.entities.GameCharacter;
import com.mpec.entities.Playable;
import com.mpec.main.Strings;
import com.mpec.mongo.manager.PutTools;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

public class TableTools {
	public static <T> void setColumnsEqualWidth(TableView<T> tv) {
		for(TableColumn<T, ?> column : tv.getColumns()) {
			column.setPrefWidth(tv.getPrefWidth() / tv.getColumns().size() - 0.5);
		}
	}
	
	public static <T> void addGameCharacterColumns(TableView<T> table) {
		DoubleStringConverter doubleConverter = new DoubleStringConverter();
		
		TableColumn<T, String> characterName = new TableColumn<T, String>(Strings.COLUMNCHARNAME);
		characterName.setCellValueFactory(new PropertyValueFactory<T, String>("name"));
		characterName.setCellFactory(TextFieldTableCell.forTableColumn());
		characterName.setOnEditCommit(value -> {
			GameCharacter c = (GameCharacter)value.getRowValue();
			PutTools.updateCharacter("name", c, value.getNewValue());
			c.setName(value.getNewValue());
		});
		
		TableColumn<T, Double> characterAttack = new TableColumn<T, Double>(Strings.COLUMNATTACK);
		characterAttack.setCellValueFactory(new PropertyValueFactory<T, Double>("attack"));
		characterAttack.setCellFactory(TextFieldTableCell.<T, Double>forTableColumn(doubleConverter));
		characterAttack.setOnEditCommit(value -> {
			GameCharacter c = (GameCharacter)value.getRowValue();
			PutTools.updateCharacter("attack", c, value.getNewValue());
			c.setAttack(value.getNewValue());
		});
		
		TableColumn<T, Double> characterDefense = new TableColumn<T, Double>(Strings.COLUMNDEFENSE);
		characterDefense.setCellValueFactory(new PropertyValueFactory<T, Double>("defense"));
		characterDefense.setCellFactory(TextFieldTableCell.<T, Double>forTableColumn(doubleConverter));
		characterDefense.setOnEditCommit(value -> {
			GameCharacter c = (GameCharacter)value.getRowValue();
			PutTools.updateCharacter("defense", c, value.getNewValue());
			c.setDefense(value.getNewValue());
		});
		
		TableColumn<T, Double> characterHp = new TableColumn<T, Double>(Strings.COLUMNHP);
		characterHp.setCellValueFactory(new PropertyValueFactory<T, Double>("hp"));
		characterHp.setCellFactory(TextFieldTableCell.<T, Double>forTableColumn(doubleConverter));
		characterHp.setOnEditCommit(value -> {
			GameCharacter c = (GameCharacter)value.getRowValue();
			PutTools.updateCharacter("hp", c, value.getNewValue());
			c.setHp(value.getNewValue());
		});
		
		TableColumn<T, Double> characterMovementSpeed = new TableColumn<T, Double>(Strings.COLUMNMOVEMENTSPEED);
		characterMovementSpeed.setCellValueFactory(new PropertyValueFactory<T, Double>("movement_speed"));
		characterMovementSpeed.setCellFactory(TextFieldTableCell.<T, Double>forTableColumn(doubleConverter));
		characterMovementSpeed.setOnEditCommit(value -> {
			GameCharacter c = (GameCharacter)value.getRowValue();
			PutTools.updateCharacter("movement_speed", c, value.getNewValue());
			c.setMovement_speed(value.getNewValue());
			
		});
		
		TableColumn<T, Double> characterAttackSpeed = new TableColumn<T, Double>(Strings.COLUMNATTACKSPEED);
		characterAttackSpeed.setCellValueFactory(new PropertyValueFactory<T, Double>("attack_speed"));
		characterAttackSpeed.setCellFactory(TextFieldTableCell.<T, Double>forTableColumn(doubleConverter));
		characterAttackSpeed.setOnEditCommit(value -> {
			GameCharacter c = (GameCharacter)value.getRowValue();
			PutTools.updateCharacter("attack_speed", c, value.getNewValue());
			c.setAttack_speed(value.getNewValue());
		});
		
		TableColumn<T, Double> characterRange = new TableColumn<T, Double>(Strings.COLUMNRANGE);
		characterRange.setCellValueFactory(new PropertyValueFactory<T, Double>("range"));
		characterRange.setCellFactory(TextFieldTableCell.<T, Double>forTableColumn(doubleConverter));
		characterRange.setOnEditCommit(value -> {
			GameCharacter c = (GameCharacter)value.getRowValue();
			PutTools.updateCharacter("range", c, value.getNewValue());
			c.setRange(value.getNewValue());
		});
		
		table.getColumns().setAll(characterName, characterAttack, characterDefense, characterHp, characterMovementSpeed, characterAttackSpeed, characterRange);
	}
	
	public static void addDropsDataColumns(TableView<DropsData> table) {
		IntegerStringConverter converter = new IntegerStringConverter();
		
		TableColumn<DropsData, String> dropsName = new TableColumn<DropsData, String>(Strings.COLUMNDROPNAME);
		dropsName.setCellValueFactory(new PropertyValueFactory<DropsData, String>("name"));
		dropsName.setCellFactory(TextFieldTableCell.forTableColumn());
		dropsName.setOnEditCommit(value -> {
			DropsData d = (DropsData)value.getRowValue();
			PutTools.updateDrops("name", d, value.getNewValue());
			d.setName(value.getNewValue());
		});
		
		TableColumn<DropsData, Integer> dropsValue = new TableColumn<DropsData, Integer>(Strings.COLUMNVALUE);
		dropsValue.setCellValueFactory(new PropertyValueFactory<DropsData, Integer>("value"));
		dropsValue.setCellFactory(TextFieldTableCell.<DropsData, Integer>forTableColumn(converter));
		dropsValue.setOnEditCommit(value -> {
			DropsData d = (DropsData)value.getRowValue();
			PutTools.updateDrops("value", d, value.getNewValue());
			d.setValue(value.getNewValue());
		});
		
		TableColumn<DropsData, Integer> dropsDuration = new TableColumn<DropsData, Integer>(Strings.COLUMNDURATION);
		dropsDuration.setCellValueFactory(new PropertyValueFactory<DropsData, Integer>("duration"));
		dropsDuration.setCellFactory(TextFieldTableCell.<DropsData, Integer>forTableColumn(converter));
		dropsDuration.setOnEditCommit(value -> {
			DropsData d = (DropsData)value.getRowValue();
			PutTools.updateDrops("duration", d, value.getNewValue());
			d.setDuration(value.getNewValue());
		});
		
		TableColumn<DropsData, Integer> dropsMinRange = new TableColumn<DropsData, Integer>(Strings.COLUMNMINRANGE);
		dropsMinRange.setCellValueFactory(new PropertyValueFactory<DropsData, Integer>("min_range"));
		dropsMinRange.setCellFactory(TextFieldTableCell.<DropsData, Integer>forTableColumn(converter));
		dropsMinRange.setOnEditCommit(value -> {
			DropsData d = (DropsData)value.getRowValue();
			PutTools.updateDrops("min_range", d, value.getNewValue());
			d.setMin_range(value.getNewValue());
		});
		
		TableColumn<DropsData, Integer> dropsMaxRange = new TableColumn<DropsData, Integer>(Strings.COLUMNMAXRANGE);
		dropsMaxRange.setCellValueFactory(new PropertyValueFactory<DropsData, Integer>("max_range"));
		dropsMaxRange.setCellFactory(TextFieldTableCell.<DropsData, Integer>forTableColumn(converter));
		dropsMaxRange.setOnEditCommit(value -> {
			DropsData d = (DropsData)value.getRowValue();
			PutTools.updateDrops("max_range", d, value.getNewValue());
			d.setMax_range(value.getNewValue());
		});
		
		table.getColumns().setAll(dropsName, dropsValue, dropsDuration, dropsMinRange, dropsMaxRange);
	}

}
