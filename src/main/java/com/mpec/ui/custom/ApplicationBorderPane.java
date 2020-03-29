package com.mpec.ui.custom;

import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class ApplicationBorderPane extends BorderPane {
	
	public ApplicationBorderPane(Parent sideBar, Parent content) {
		super();
		this.setLeft(sideBar);
		this.setCenter(content);
	}
	
	public void switchContent(Parent content) {
		this.setCenter(content);
	}

}
