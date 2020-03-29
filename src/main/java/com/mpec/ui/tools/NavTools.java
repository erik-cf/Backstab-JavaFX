package com.mpec.ui.tools;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;

public class NavTools {

	public static Label searchLabelOnNavBar(ObservableList<Node> nodes, String text) {
		for(Node label : nodes) {
			if(((Label)label).getText().equalsIgnoreCase(text))
				return (Label)label;
		}
		return null;
	}
	
}
