import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;

public class Entrada {
    public static void main(String[] args) {
       /* File file = new File("src/main/java/resources/usuario.txt");
        //para convertir un txt -> JSON
        BufferedReader bufferedReader=null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            StringBuffer lecturaCompleta = new StringBuffer();
            String linea = null;

            while ((linea = bufferedReader.readLine())!= null){
                lecturaCompleta.append(linea);
            }
            //System.out.println(lecturaCompleta.toString());
            JSONObject usuario = new JSONObject(lecturaCompleta.toString());
            String nombreUsuario = usuario.getString("nombre");
            System.out.println(nombreUsuario);

            JSONArray asignaturas = usuario.getJSONArray("asignatura");
            System.out.println(asignaturas);

        } catch (FileNotFoundException e) {
            System.out.println("Error en el fichero");
        } catch (IOException e) {
            System.out.println("Error al leer");
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println("Error en el cerrado");
            }
        }*/
        PeticionJSON peticionJSON = new PeticionJSON();
        peticionJSON.procesarPeticion();

        // Entrada nueva
        // 1. Leer productos -> imprima informacion de los productos Nombre, precio, stock, descripcion
        //2 . buscar productos --> pida por teclado un ID y muestre la informacion de dicho producto
        //3. Filtrar por precio -> pide un precio minimo o max y se muestran los productos que cumplen el filtro
        //4. exportar productos -> escribe en un .txt todos los productos de la URL -> JSON
        // BUSCAR INFORMACION DE LA LIBRERIA GSON
    }
}
