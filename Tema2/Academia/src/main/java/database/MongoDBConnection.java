package database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;

public class MongoDBConnection {
    private String connectionString = "mongodb+srv://%s:%s@cluster0.541fa.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

    private MongoClient mongoClient;

    public MongoDBConnection(){
        mongoClient = MongoClients.create(String.format(connectionString, DBScheme.USER, DBScheme.PASS));
    }

    public MongoCollection getUserCollection(){
        return mongoClient.getDatabase("academia").getCollection("usuarios");
    }
}
