package com.mpec.main;

import com.mpec.entities.User;
import com.mpec.ui.custom.BaseStage;

import javafx.scene.control.Label;

public final class Constants {
	////////////////////////////////////////// UI //////////////////////////////////////////
	/**
	 * Estáticas de la aplicación, para todas las clases el usuario logueado y la ventana principal debería ser igual.
	 */
	public static User loggedUser;
	public static BaseStage baseStage;
	public static Label selectedLabel;
	
	/**
	 * Tamaño de la ventana, partiendo de la resolución de pantalla.
	 */
	public static final int WINDOW_BASE_WIDTH = 1366;
	public static final int WINDOW_BASE_HEIGHT = 768;
	

	////////////////////////////////////////// MONGO //////////////////////////////////////////
	/**
	 * URI de conexión a mongo.
	 */
	public static final String MONGO_URI = "mongodb+srv://erikcf:erikcf@m06-cabezueloerik-e7cnn.mongodb.net/test?retryWrites=true&w=majority";
	
	/**
	 * Nombres de las colecciones:
	 */
	public static final String DROPS_DATA = "DropsData";
	public static final String ENEMY = "Enemy";
	public static final String GAME_PARAMS = "GameParams";
	public static final String GAME_STATISTICS = "GameStatistics";
	public static final String MAIN_CHARACTER = "MainCharacter";
	public static final String PLAYER_STATISTICS = "PlayerStatistics";
	public static final String USER = "User";

	/**
	 * Nombre de la BD
	 */
	public static final String MONGO_DATABASE = "Backstab";
	
	////////////////////////////////////////// APP Config //////////////////////////////////////////
	public static String language = "spanish";
	public static String mode = "light";
}
