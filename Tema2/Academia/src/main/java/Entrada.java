import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import database.DBScheme;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Entrada {
    public static void main(String[] args) {
        // Crear conexión
        String connectionString = "mongodb+srv://%s:%s@cluster0.541fa.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(String.format(connectionString, DBScheme.USER, DBScheme.PASS)))
                .serverApi(serverApi)
                .build();

        // Para llegar a la conexión
        // para un servidor ya configurado -> MongoClient mongoClient = MongoClients.create(settings);
        MongoClient mongoClient = MongoClients.create(String.format(connectionString, DBScheme.USER, DBScheme.PASS));

        // database --> hasta que no creamos una coleccion no se crea la db
        MongoDatabase database = mongoClient.getDatabase("academia");

        // collection --> hasta que no creamos un documento no se crea la coleccion
        MongoCollection collection = database.getCollection("usuarios");

        // Document --> {clave:valor}
            // Create -> insertOne / Many
        /*Document documentInsercion = new Document();
        documentInsercion.append("nombre", "Sikem");
        documentInsercion.append("apellido", "Iglesias");
        documentInsercion.append("edad", 33);
        documentInsercion.append("correo", "Sikem@correo.com");
        collection.insertOne(documentInsercion);*/

       /*List<Document> listaInsercion = Arrays.asList(
                new Document().append("nombre", "Pepe").append("apellido", "Gomez").append("edad", 20).append("correo","pepe@correo.es"),
                new Document().append("nombre", "Juan").append("apellido", "Perez").append("edad", 30).append("correo","juan@correo.es"),
                new Document().append("nombre", "Ana").append("apellido", "Fernandez").append("edad", 40).append("correo","ana@correo.es")
        );
        collection.insertMany(listaInsercion);*/

            // Update -> updateOne / Many
        // Hay que decirle que documento hay que actualizar y las condiciones de actualizacion
        /*Document documentBusqueda = new Document().append("edad", new Document().append("$lte", 30));
        Document documentoCambio = new Document().append("$set", new Document("edad", 35));
        UpdateResult result = collection.updateMany(documentBusqueda, documentoCambio);
        System.out.printf("El resultado de la actualizacion han sido %d registros" , result.getModifiedCount());
        */


            // Delete -> delete
        /*Document document = new Document();
        document.append("edad" , new Document().append("$gt", 45));
        DeleteResult deleteResult = collection.deleteMany(document);
        System.out.println("El resultado del borrado es: " + deleteResult.getDeletedCount());
        */

            // Select -> find
        /* filtro --> Document filtroEdad = new Document().append("edad", new Document().append("$gt", 30).append("$lt", 40));
        FindIterable resultado = collection.find(filtroEdad);
        MongoCursor <Document> cursor = resultado.iterator(); // ResulSet

        while(cursor.hasNext()){
            Document document = cursor.next();
            String nombre = document.getString("nombre");
            String apellido = document.getString("apellido");
            int edad = document.getInteger("edad");
            System.out.println(nombre + " " + apellido + " " + edad);
        }*/



    }
}
