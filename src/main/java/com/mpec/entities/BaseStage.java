package com.mpec.entities;

import com.mpec.main.Constants;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BaseStage extends Stage {
	
	private BorderPane root;
	
	public BaseStage(User loggedUser) {
		Constants.loggedUser = loggedUser;
		this.setWidth(Constants.WINDOW_BASE_WIDTH);
		this.setHeight(Constants.WINDOW_BASE_HEIGHT);
		root = new BorderPane();
		
	}
	
}
