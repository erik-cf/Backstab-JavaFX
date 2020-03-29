package com.mpec.ui.custom;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class ApplicationMenuBar extends MenuBar {

	private Menu docs;
	private Menu view;
	private MenuItem viewConfig;
	private MenuItem newDocs;
	private MenuItem searchDocs;
	
	public ApplicationMenuBar(BorderPane root) {
		super();
		docs = new Menu("Documents");
		view = new Menu("View");
		viewConfig = new MenuItem("Configuration");
		newDocs = new MenuItem("New...");
		searchDocs = new MenuItem("Search...");
		view.getItems().add(viewConfig);
		docs.getItems().addAll(newDocs, searchDocs);
		this.getMenus().addAll(docs, view);
		this.setWidth(root.getWidth());
	}

	public Menu getApp() {
		return docs;
	}

	public void setApp(Menu app) {
		this.docs = app;
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
