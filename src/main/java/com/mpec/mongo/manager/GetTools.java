package com.mpec.mongo.manager;


import java.util.ArrayList;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mpec.main.Constants;
import com.mpec.mongo.connection.MongoConnection;

public class GetTools extends MongoConnection {
	
	public static boolean validateLogin(String username, String password) {
		ArrayList<Bson> filters = new ArrayList<Bson>();
		filters.add(Filters.eq("username", username));
		filters.add(Filters.eq("password", password));
		MongoCollection<Document> userCol = getMongoCollection(Constants.USER);
		FindIterable<Document> userFound = userCol.find(Filters.and(filters));
		if(userFound.first() == null) {
			return false;
		}
		return true;
	}

}
