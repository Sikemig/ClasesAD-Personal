import org.json.JSONObject;
import java.io.*;

public class Entrada {
    public static void main(String[] args) {
        File file = new File("src/main/java/resources/usuario.txt");
        //txt -> JSON
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

        } catch (FileNotFoundException e) {
            System.out.println("Error en el fichero");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println("Error en el cerrado");
            }
        }
    }
}
