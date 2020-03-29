package com.mpec.ui.custom;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class ApplicationMenuBar extends MenuBar {

	private Menu app;
	private Menu view;
	private MenuItem viewConfig;
	
	public ApplicationMenuBar(BorderPane root) {
		super();
		app = new Menu("Application");
		view = new Menu("View");
		viewConfig = new MenuItem("Configuration");
		view.getItems().add(viewConfig);
		this.getMenus().addAll(app, view);
		this.setWidth(root.getWidth());
	}

	public Menu getApp() {
		return app;
	}

	public void setApp(Menu app) {
		this.app = app;
	}

	public Menu getView() {
		return view;
	}

	public void setView(Menu view) {
		this.view = view;
	}

	public MenuItem getViewConfig() {
		return viewConfig;
	}

	public void setViewConfig(MenuItem viewConfig) {
		this.viewConfig = viewConfig;
	}	
}
