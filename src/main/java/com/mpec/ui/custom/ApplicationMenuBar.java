package com.mpec.ui.custom;

import java.io.IOException;

import com.mpec.main.Strings;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ApplicationMenuBar extends MenuBar {

	/**
	 * Menus.
	 */
	private Menu app;
	private Menu cols;
	private Menu view;
	
	/**
	 * MenuItems.
	 */
	private MenuItem closeApp;
	private MenuItem logoutApp;
	private MenuItem viewConfig;
	private MenuItem languageConfig;
	private MenuItem newCols;
	private MenuItem viewCols;
	
	/**
	 * BorderPane that contains the MenuBar
	 */
	private BorderPane root;
		
	public ApplicationMenuBar(BorderPane root) {
		super();
		this.root = root;

		initialize();
		
		setListeners();
		this.setWidth(this.root.getWidth());
		
	}
	
	private void initialize() {
		// Initialize menus
		app = new Menu(Strings.APPLICATIONMENU);
		cols = new Menu(Strings.DOCUMENTSMENU);
		view = new Menu(Strings.VIEWMENU);
		
		// Initialize MenuItems
		logoutApp = new MenuItem(Strings.LOGOUTMENUITEM);
		closeApp = new MenuItem(Strings.EXITMENUITEM);
		viewConfig = new MenuItem(Strings.CONFIGURATIONMENUITEM);
		languageConfig = new MenuItem(Strings.LANGUAGEMENUITEM);
		newCols = new MenuItem(Strings.NEWMENUITEM);
		viewCols = new MenuItem(Strings.VIEWEDITCOLS);
		
		// Add MenuItems to Menu
		app.getItems().addAll(languageConfig, logoutApp, closeApp);
		view.getItems().add(viewConfig);
		cols.getItems().addAll(newCols, viewCols);
		
		// Add Menus to MenuBar
		this.getMenus().addAll(app, cols, view);
	}
	
	private void setListeners() {
		// Mostramos la pantalla de Login al clicar Logout
		logoutApp.setOnAction(event -> {
			Parent loginParent = null;
			try {
				loginParent = FXMLLoader.load(getClass().getResource("../fxml/login/login_fxml.fxml"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			Scene scene = new Scene(loginParent, 600, 400);
			Stage loginStage = new Stage();
			loginStage.setScene(scene);
			((BaseStage)this.root.getScene().getWindow()).close();
			loginStage.show();
		});
		
		// Cerramos la aplicación al clicar el MenuItem de closeApp.
		closeApp.setOnAction(event -> {
			System.exit(0);
		});
		
		languageConfig.setOnAction(event -> {
			SelectLanguageStage selectLanguage = new SelectLanguageStage(((BaseStage)this.root.getScene().getWindow()));
			selectLanguage.show();
		});
		
		viewConfig.setOnAction(event -> {
			ConfigurationStage confStage = new ConfigurationStage(((BaseStage)this.root.getScene().getWindow()));
			confStage.show();
		});
		
		newCols.setOnAction(event -> {
			NewCollectionStage newColStage = new NewCollectionStage((BaseStage)this.root.getScene().getWindow());
			newColStage.show();
		});
		
		viewCols.setOnAction(event -> {
			SeeCollectionsStage seeColsStage = new SeeCollectionsStage((BaseStage)this.root.getScene().getWindow());
			seeColsStage.show();
		});
		
		
	}

	/**
	 * Get the app Menu.
	 * @return The app Menu.
	 */
	public Menu getApp() {
		return cols;
	}

	public void setApp(Menu app) {
		this.cols = app;
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
