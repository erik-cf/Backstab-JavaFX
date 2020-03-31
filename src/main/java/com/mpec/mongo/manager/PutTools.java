package com.mpec.mongo.manager;

import java.util.ArrayList;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoNamespace;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mpec.encription.HashTools;
import com.mpec.entities.DropsData;
import com.mpec.entities.GameCharacter;
import com.mpec.entities.Map;
import com.mpec.main.Constants;
import com.mpec.main.Strings;
import com.mpec.mongo.connection.MongoConnection;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class PutTools extends MongoConnection{
	
	public static void changePassword(String newPassword) {
		getMongoCollection(Constants.USER).findOneAndUpdate(Filters.eq("username", Constants.loggedUser.getUsername()), Updates.set("password", HashTools.stringToMD5(newPassword)));
	}
	
	public static <T> void updateCharacter(String field, GameCharacter c, T value) {
		MongoCollection<Document> collection;
		if(c.getType() == GameCharacter.PLAYABLE) {
			collection = getMongoCollection(Constants.MAIN_CHARACTER);
		}else {
			collection = getMongoCollection(Constants.ENEMY);
		}
		collection.findOneAndUpdate(Filters.eq("name", c.getName()), Updates.set(field, value));
	}
	
	public static <T> void updateDrops(String field, DropsData d, T value) {
		getMongoCollection(Constants.DROPS_DATA).findOneAndUpdate(Filters.eq("name", d.getName()), Updates.set(field, value));
	}
	
	public static void updateGameParams(Map gameParams, Map oldGameParams) {
		ArrayList<Bson> updatesAL = new ArrayList<Bson>();
		updatesAL.add(Updates.set("phase_time", gameParams.getPhase_time()));
		updatesAL.add(Updates.set("min_drop_time", gameParams.getMin_drop_time()));
		updatesAL.add(Updates.set("max_drop_time", gameParams.getMax_drop_time()));
		updatesAL.add(Updates.set("base_monsters_count", gameParams.getBase_monsters_count()));
		updatesAL.add(Updates.set("collision_probability", gameParams.getCollision_probability()));
		getMongoCollection(Constants.GAME_PARAMS).findOneAndUpdate(Filters.eq("phase_time", oldGameParams.getPhase_time()), updatesAL);
	}
	
	public static boolean updateCollectionName(String oldValue, String newValue) {
		if(getMongoCollection(oldValue) == null) {
			new Alert(AlertType.ERROR, Strings.COLLECTIONDOESNTEXISTS, ButtonType.CLOSE).show();
			return false;
		}
		if(getMongoCollection(newValue) != null) {
			new Alert(AlertType.ERROR, Strings.COLLECTIONEXISTS, ButtonType.CLOSE).show();
			return false;
		}
		MongoNamespace mongoNS = new MongoNamespace(Constants.MONGO_DATABASE, newValue);
		getMongoCollection(oldValue).renameCollection(mongoNS);
		return true;
		
	}
}
