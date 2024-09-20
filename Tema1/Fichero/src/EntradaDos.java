import controller.GestorFicheros;

import java.io.FileNotFoundException;

public class EntradaDos {

    public static void main(String[] args) {
        GestorFicheros gestorFicheros = new GestorFicheros();
       // gestorFicheros.lecturaDirectorios("src/resources/directorio");
       // gestorFicheros.lecturaDirectorios("src/resources/ficheros");

       // gestorFicheros.lecturaRecursiva("C:\\Users\\Sikem\\Documents");
        gestorFicheros.lecturaTextoPlano("src/resources/ficheros/lectura.txt");
    }

}
