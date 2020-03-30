package com.mpec.mongo.manager;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mpec.encription.HashTools;
import com.mpec.main.Constants;
import com.mpec.mongo.connection.MongoConnection;

public class PutTools extends MongoConnection{
	
	public static void changePassword(String newPassword) {
		getMongoCollection(Constants.USER).findOneAndUpdate(Filters.eq("username", Constants.loggedUser.getUsername()), Updates.set("password", HashTools.stringToMD5(newPassword)));
	}
	
}
