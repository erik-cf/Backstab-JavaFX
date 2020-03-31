package com.mpec.config;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.mpec.main.Constants;

public class ConfigTools {
	public static final String MODE = "mode";
	public static final String LANGUAGE = "language";
	
	private static File configFile = new File("backstab.conf");
	
	public static String readConfig(String field) throws IOException {
		FileReader reader = new FileReader(configFile);
		
		Constants.props.load(reader);
		return Constants.props.getProperty(field);
	}
	
	public static void writeConfig(String field, String value) throws IOException {
		FileWriter writer = new FileWriter(configFile);
		Constants.props.setProperty(field, value);
		Constants.props.store(writer, field + "settings");
		writer.close();
	}

}
