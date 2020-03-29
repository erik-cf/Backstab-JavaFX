package com.mpec.mongo.connection;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mpec.main.Constants;

public class MongoConnection {

		/**
		 * Objetos necesarios para la conexión con mongo.
		 */
		private static MongoClientURI uri;
		private static MongoClient mongoClient;
		private static MongoDatabase database;

		/**
		 * Inicializa la conexión a Mongo.
		 */
		public static void initialize() {
			// Inicializamos la URI
			uri = new MongoClientURI(Constants.MONGO_URI);
			// Inicializamos el cliente de mongo
			mongoClient = new MongoClient(uri);
			// Inicializamos la DataBase
			database = mongoClient.getDatabase(Constants.MONGO_DATABASE);
		}
		
		/**
		 * Método que retorna una colección según el identificador que se le pasa por parámetro. 
		 * Debes pasarle uno de los nombres de colección que se encuentran en Constants.
		 * @param collection - El nombre de la colección a recoger. i.e. Constants.DROPS_DATA.
		 * @return La colección de tipo MongoCollection<Document>.
		 */
		public static MongoCollection<Document> getMongoCollection(String collection) {
			return database.getCollection(collection);
		}
		
		
	
}
