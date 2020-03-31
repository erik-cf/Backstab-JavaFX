package com.mpec.ui.tools;

public class Validation {
	
	public static boolean validateInteger(String value) {
		try {
			Integer.parseInt(value);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
}
