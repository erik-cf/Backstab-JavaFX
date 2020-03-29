package com.mpec.mongo.manager;


import java.util.ArrayList;
import java.util.Iterator;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mpec.entities.DropsData;
import com.mpec.entities.Enemy;
import com.mpec.entities.GameCharacter;
import com.mpec.entities.Playable;
import com.mpec.entities.User;
import com.mpec.main.Constants;
import com.mpec.mongo.connection.MongoConnection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GetTools extends MongoConnection {
	
	public static User validateLogin(String username, String password) {
		ArrayList<Bson> filters = new ArrayList<Bson>();
		filters.add(Filters.eq("username", username));
		filters.add(Filters.eq("password", password));
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
			data.add((T)new GameCharacter(doc.getString("name"), doc.getDouble("attack"), doc.getDouble("defense"), doc.getDouble("hp"), doc.getDouble("movement_speed"), doc.getDouble("attack_speed"), doc.getDouble("range")));
		}
		return FXCollections.observableArrayList(data);
	}
	
	public static Document getFirstDocumentAlone(String collection) {
		return getMongoCollection(collection).find().first();
	}
	
	public static ObservableList<DropsData> getDropsData(){
		ArrayList<DropsData> data = new ArrayList<DropsData>();
		FindIterable<Document> usersIterable = getMongoCollection(Constants.DROPS_DATA).find();
		Iterator<Document> i = usersIterable.iterator();
		Document doc;
		while(i.hasNext()) {
			doc = i.next();
			data.add(new DropsData(doc.getString("name"), doc.getInteger("value"), doc.getInteger("duration"), doc.getInteger("min_range"), doc.getInteger("max_range")));
		}
		return FXCollections.observableArrayList(data);
	}

}
