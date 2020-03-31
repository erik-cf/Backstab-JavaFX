package com.mpec.mongo.manager;


import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.codec.binary.Base64;
import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mpec.encription.AsymmetricTools;
import com.mpec.encription.HashTools;
import com.mpec.entities.DropsData;
import com.mpec.entities.Enemy;
import com.mpec.entities.GameCharacter;
import com.mpec.entities.Playable;
import com.mpec.entities.User;
import com.mpec.main.Constants;
import com.mpec.mongo.connection.MongoConnection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class GetTools extends MongoConnection {
	
	public static final String PRIVATE_KEY = "private_key";
	public static final String PUBLIC_KEY = "public_key";
	
	public static User validateLogin(String username, String password) {
		ArrayList<Bson> filters = new ArrayList<Bson>();
		filters.add(Filters.eq("username", username));
		filters.add(Filters.eq("password", HashTools.stringToMD5(password)));
		MongoCollection<Document> userCol = getMongoCollection(Constants.USER);
		FindIterable<Document> usersIterable = userCol.find(Filters.and(filters));
		Document doc = usersIterable.first();
		if(doc == null) {
			return null;
		}
		return new User(doc.getString("name"), doc.getString("surname"), doc.getString("mail"), doc.getString("username"), doc.getString("password"), doc.getInteger("role"));
	}
	
	public static <T> ObservableList<T> getCharacter(String collection, Class<T> charClass) {
		if(!collection.equalsIgnoreCase(Constants.ENEMY) && !collection.equalsIgnoreCase(Constants.MAIN_CHARACTER)) {
			throw new RuntimeException("You can only use Enemy or MainCharacter collections on this method!");
		}
		if(!charClass.equals(GameCharacter.class) && !charClass.equals(Playable.class) && !charClass.equals(Enemy.class)) {
			throw new RuntimeException("You can only use GameCharacter, Enemy or Playable class on this method!");
		}
		ArrayList<T> data = new ArrayList<T>();
		FindIterable<Document> usersIterable = getMongoCollection(collection).find();
		Iterator<Document> i = usersIterable.iterator();
		Document doc;
		while(i.hasNext()) {
			doc = i.next();
			if(collection.equals(Constants.ENEMY)) {
				data.add((T)new GameCharacter(doc.getString("name"), doc.getDouble("attack"), doc.getDouble("defense"), doc.getDouble("hp"), doc.getDouble("movement_speed"), doc.getDouble("attack_speed"), doc.getDouble("range"), GameCharacter.ENEMY));
			}else {
				data.add((T)new GameCharacter(doc.getString("name"), doc.getDouble("attack"), doc.getDouble("defense"), doc.getDouble("hp"), doc.getDouble("movement_speed"), doc.getDouble("attack_speed"), doc.getDouble("range"), GameCharacter.PLAYABLE));
			}
		}
		return FXCollections.observableArrayList(data);
	}
	
	public static Document getFirstDocumentAlone(String collection) {
		return getMongoCollection(collection).find().first();
	}
	
	public static ObservableList<DropsData> getDropsData(){
		ArrayList<DropsData> data = new ArrayList<DropsData>();
		FindIterable<Document> dropsDataIterable = getMongoCollection(Constants.DROPS_DATA).find();
		Iterator<Document> i = dropsDataIterable.iterator();
		Document doc;
		while(i.hasNext()) {
			doc = i.next();
			data.add(new DropsData(doc.getString("name"), doc.getInteger("value"), doc.getInteger("duration"), doc.getInteger("min_range"), doc.getInteger("max_range")));
		}
		return FXCollections.observableArrayList(data);
	}
	
	public static byte[] getAsymetricKey(String key) {
		return Base64.decodeBase64(getMongoCollection("Crypto").find().first().getString(key));
	}
	
	public static boolean checkIfFieldExists(String collection, String field, String value) {
		return getMongoCollection(collection).find(Filters.eq(field, value)).first() != null;
	}
	
	public static boolean checkIfEncriptedFieldExists(String collection, String field, String value) {
		try {
			return getMongoCollection(collection).find(Filters.eq(field, AsymmetricTools.encryptText(value))).first() != null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public static ObservableList<User> getUsersResult(String field, String value) {
		ArrayList<User> usersAL = new ArrayList<User>();
		
		FindIterable<Document> iterable = getMongoCollection(Constants.USER).find(Filters.eq(field, value));
		Iterator<Document> it = iterable.iterator();
		Document doc;
		User user ;
		while(it.hasNext()) {
			doc = it.next();
			try {
				user = new User(doc.getString("name"), doc.getString("surname"), AsymmetricTools.decryptText(doc.getString("mail")), doc.getString("username"), doc.getString("password"), doc.getInteger("role"));
				usersAL.add(user);
			} catch (Exception e) {
				new Alert(AlertType.ERROR, "ERROR Decrypting mail", ButtonType.CLOSE);
			}
		}
		return FXCollections.observableArrayList(usersAL);
	}

}
