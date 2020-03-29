package com.mpec.entities;

import com.mpec.main.Constants;

import javafx.stage.Stage;

public class BaseStage extends Stage {
	
	
	
	public BaseStage(User loggedUser) {
		Constants.loggedUser = loggedUser;
		this.setWidth(Constants.WINDOW_BASE_WIDTH);
		this.setHeight(Constants.WINDOW_BASE_HEIGHT);
	}
	
}
