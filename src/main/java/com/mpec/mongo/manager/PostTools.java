package com.mpec.mongo.manager;

import org.bson.Document;

import com.mpec.encription.AsymmetricTools;
import com.mpec.entities.User;
import com.mpec.main.Constants;
import com.mpec.main.Strings;
import com.mpec.mongo.connection.MongoConnection;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class PostTools extends MongoConnection{

	public static void postUser(User newUser) {
		Document docToInsert = new Document();
		docToInsert.append("name", newUser.getName());
		docToInsert.append("surname", newUser.getSurname());
		docToInsert.append("username", newUser.getUsername());
		docToInsert.append("password", newUser.getPassword());
		try {
			docToInsert.append("mail", AsymmetricTools.encryptText(newUser.getMail()));
		} catch (Exception e) {
			new Alert(AlertType.ERROR, Strings.ERRORENCRYPTING, ButtonType.CLOSE).show();
			return;
		}
		docToInsert.append("role", newUser.getRole());
		getMongoCollection(Constants.USER).insertOne(docToInsert);
	}
	
	public static boolean createCollection(String collectionName) {
		if(getMongoCollection(collectionName) == null) {
			getDatabase().createCollection(collectionName);
			return true;
		}else {
			new Alert(AlertType.ERROR, Strings.COLLECTIONEXISTS, ButtonType.CLOSE).show();
			return false;
		}
	}
	
}
