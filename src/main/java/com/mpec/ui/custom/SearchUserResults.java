package com.mpec.ui.custom;

import com.mpec.entities.User;
import com.mpec.main.Strings;
import com.mpec.ui.tools.TableTools;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SearchUserResults extends Stage {
	private VBox mainPanel; 
	private TableView<User> resultsTable;
	private Button closeButton;
	
	ObservableList<User> usersData;
	
	public SearchUserResults(BaseStage mainStage, ObservableList<User> usersData) {
		this.usersData = usersData;
		this.initModality(Modality.WINDOW_MODAL);
		this.initOwner(mainStage);
		initialize();
		modify();
		prepareTableView();
		fillTable();
		setListeners();
		addComps();
	}
	
	private void initialize() {
		mainPanel = new VBox();
		resultsTable = new TableView<User>();
		closeButton = new Button(Strings.EXITMENUITEM);
	}
	
	private void modify() {
		this.setWidth(800);
		this.setHeight(300);
		resultsTable.setPrefSize(795, 240);
		mainPanel.setSpacing(20);
		mainPanel.setAlignment(Pos.CENTER);
		mainPanel.setPadding(new Insets(10));
		closeButton.setPrefSize(100, 40);
		
	}
	
	private void prepareTableView() {
		TableColumn<User, String> nameColumn = new TableColumn<User, String>(Strings.NAMELABEL);
		nameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
		
		TableColumn<User, String> surnameColumn = new TableColumn<User, String>(Strings.SURNAMELABEL);
		surnameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("surname"));
		
		TableColumn<User, String> usernameColumn = new TableColumn<User, String>(Strings.USERNAMELABEL);
		usernameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
		
		TableColumn<User, String> mailColumn = new TableColumn<User, String>(Strings.MAILLABEL);
		mailColumn.setCellValueFactory(new PropertyValueFactory<User, String>("mail"));
		
		TableColumn<User, Integer> roleColumn = new TableColumn<User, Integer>(Strings.ROLELABEL);
		roleColumn.setCellValueFactory(new PropertyValueFactory<User, Integer>("role"));
		
		resultsTable.getColumns().addAll(nameColumn, surnameColumn, usernameColumn, mailColumn, roleColumn);
		TableTools.setColumnsEqualWidth(resultsTable);
	}
	
	private void fillTable() {
		resultsTable.setItems(usersData);
	}
	
	private void setListeners() {
		closeButton.setOnAction(event -> {
			this.close();
		});
	}
	
	private void addComps() {
		mainPanel.getChildren().addAll(resultsTable, closeButton);
		this.setScene(new Scene(mainPanel));
	}
}
