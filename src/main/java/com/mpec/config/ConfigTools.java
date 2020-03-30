package com.mpec.config;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class ConfigTools {
	public static final String MODE = "mode";
	public static final String LANGUAGE = "language";
	
	private static File configFile = new File("backstab.conf");
	
	public static String readConfig(String field) throws IOException {
		FileReader reader = new FileReader(configFile);
		Properties props = new Properties();
		props.load(reader);
		return props.getProperty(field);
	}
	
	public static void writeConfig(String field, String value) throws IOException {
		Properties props = new Properties();
		FileWriter writer = new FileWriter(configFile);
		props.setProperty(field, value);
		props.store(writer, field + "settings");
		writer.close();
	}

}
