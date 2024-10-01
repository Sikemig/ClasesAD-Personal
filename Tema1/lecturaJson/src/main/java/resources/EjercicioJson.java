package resources;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class EjercicioJson {

    // Ejercicio 1
    public void peticionJSON(){
        String urlString = "https://dummyjson.com/products";

        try {
            // Conexion con la pagina
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            //Lectura de informacion
            String linea = null;
            StringBuffer stringBuffer = new StringBuffer();
            while((linea = bufferedReader.readLine())!=null){
                stringBuffer.append(linea);
            }

            //Navegar por la informacion
            JSONObject peticionProductos = new JSONObject(stringBuffer.toString());
            JSONArray listaProductos = new JSONArray(peticionProductos.getJSONArray("products"));

            for (Object item : listaProductos){
                JSONObject producto = (JSONObject) item;
                System.out.println("Nombre Producto: "+ producto.getString("title"));
                System.out.println("Precio Producto: "+ producto.getDouble("price"));
                System.out.println("Stock Producto: "+ producto.getInt("stock"));
                System.out.println("Descripcion Producto: "+ producto.getString("description"));
                System.out.println();
            }

        } catch (MalformedURLException e) {
            System.out.println("No es una web, por favor intentelo de nuevo");
        } catch (IOException e) {
            System.out.println("Error en la pagina, no responde");
        }
    }

    //Ejercicio 2
    public void lecturaID(){
        String urlString = "https://dummyjson.com/products";

        try {
            // Conexion con la pagina
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            //Lectura de informacion
            String linea = null;
            StringBuffer stringBuffer = new StringBuffer();
            while((linea = bufferedReader.readLine())!=null){
                stringBuffer.append(linea);
            }

            //Navegar por la informacion
            JSONObject peticionProductos = new JSONObject(stringBuffer.toString());
            JSONArray listaProductos = new JSONArray(peticionProductos.getJSONArray("products"));

            int id = 0;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Por favor, introduzca el ID del producto");
            id=scanner.nextInt();

            for (Object item : listaProductos){
                JSONObject producto = (JSONObject) item;
                if(id == producto.getInt("id")) {
                    System.out.println("Nombre Producto: " + producto.getString("title"));
                    System.out.println("Precio Producto: " + producto.getDouble("price"));
                    System.out.println("Stock Producto: " + producto.getInt("stock"));
                    System.out.println("Descripcion Producto: " + producto.getString("description"));
                }
            }

        } catch (MalformedURLException e) {
            System.out.println("No es una web, por favor intentelo de nuevo");
        } catch (IOException e) {
            System.out.println("Error en la pagina, no responde");
        }
    }

    //Ejercicio 3
    public void lecturaPrecio(){
        String urlString = "https://dummyjson.com/products";

        try {
            // Conexion con la pagina
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            //Lectura de informacion
            String linea = null;
            StringBuffer stringBuffer = new StringBuffer();
            while((linea = bufferedReader.readLine())!=null){
                stringBuffer.append(linea);
            }

            //Navegar por la informacion
            JSONObject peticionProductos = new JSONObject(stringBuffer.toString());
            JSONArray listaProductos = new JSONArray(peticionProductos.getJSONArray("products"));

            double precioMin, precioMax = 0;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Por favor, introduzca el precio minimo");
            precioMin=scanner.nextInt();
            System.out.println("Por favor, introduzca el precio maximo");
            precioMax=scanner.nextInt();

            for (Object item : listaProductos){
                JSONObject producto = (JSONObject) item;
                if(precioMin <= producto.getDouble("price") && precioMax >= producto.getDouble("price")) {
                    System.out.println("Nombre Producto: " + producto.getString("title"));
                    System.out.println("Precio Producto: " + producto.getDouble("price"));
                    System.out.println("Stock Producto: " + producto.getInt("stock"));
                    System.out.println("Descripcion Producto: " + producto.getString("description"));
                }
            }

        } catch (MalformedURLException e) {
            System.out.println("No es una web, por favor intentelo de nuevo");
        } catch (IOException e) {
            System.out.println("Error en la pagina, no responde");
        }
    }

    //Ejercicio 4
    public void exportar() {
        String urlString = "https://dummyjson.com/products";

        //Preparamos la escritura
        File file = new File("src/main/java/resources/exportacion.txt");
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, false));

            try {
                // Conexion con la pagina
                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));


                //Lectura de informacion
                String linea = null;
                StringBuffer stringBuffer = new StringBuffer();
                while ((linea = bufferedReader.readLine()) != null) {
                    stringBuffer.append(linea);
                }

                //Navegar por la informacion
                JSONObject peticionProductos = new JSONObject(stringBuffer.toString());
                JSONArray listaProductos = new JSONArray(peticionProductos.getJSONArray("products"));

                for (Object item : listaProductos) {
                    JSONObject producto = (JSONObject) item;
                    bufferedWriter.append(producto.getString("title"));
                    bufferedWriter.newLine();
                }

                System.out.println("Se ha completado la exportación");

            } catch (MalformedURLException e) {
                System.out.println("No es una web, por favor intentelo de nuevo");
            } catch (IOException e) {
                System.out.println("Error en la pagina, no responde");
            } finally {
                bufferedWriter.close();
            }

        } catch (IOException e) {
            System.out.println("No se encuentra el archivo");
        }
    }
}
