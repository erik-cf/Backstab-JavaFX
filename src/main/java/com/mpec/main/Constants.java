package com.mpec.main;

import java.io.IOException;
import java.util.Properties;

import com.mpec.config.ConfigTools;
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
	public static final Properties props = new Properties();
	
	
	public static String language = getLanguage();
	public static String mode = getMode();
	
	public static String getLanguage() {
		try {
			return ConfigTools.readConfig(ConfigTools.LANGUAGE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "english";
	}
	
	public static String getMode() {
		try {
			return ConfigTools.readConfig(ConfigTools.MODE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "dark";
	}
	
	public static void initializeProperties() {
			try {
				props.getProperty(ConfigTools.readConfig(ConfigTools.LANGUAGE));
				props.getProperty(ConfigTools.readConfig(ConfigTools.MODE));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
