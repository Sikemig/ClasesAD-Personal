import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PeticionJSON {

    public void procesarPeticion(){
        // URL -> HTTPCONNECTION -> BUFFERREADER
        String urlString = "https://dummyjson.com/products";
        try {
            // Conexion con la pagina
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            //Lectura de informacion
            String linea = null;
            StringBuffer stringBuffer= new StringBuffer();
            while ((linea = bufferedReader.readLine())!=null){
                stringBuffer.append(linea);
            }

            //Pasarlo a jsonobject y navegar por ello
            JSONObject peticionProductos = new JSONObject(stringBuffer.toString());
            JSONArray listaProductos = peticionProductos.getJSONArray("products");
            for(Object item : listaProductos){ //tiene que ser Object porque puede que haya cosas que no son JSONObject
                //item es un JSONOBJECT -> lo sabemos de antemano
                JSONObject producto = (JSONObject) item;
                System.out.println("Titulo: " + producto.getString("title"));
                System.out.println("Precio: " + producto.getDouble("price"));

                JSONArray tags = producto.getJSONArray("tags");
                System.out.println("Las categorias del producto son: ");
                for(Object tag:tags){
                    System.out.println("\t" + tag);
                }
            }


        } catch (MalformedURLException e) {
            System.out.println("No es una web, por favor intentelo de nuevo");
        } catch (IOException e) {
            System.out.println("Error en la pagina, no responde");
        }

    }
}
