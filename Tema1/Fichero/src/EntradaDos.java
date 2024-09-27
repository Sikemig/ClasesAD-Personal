import controller.GestorFicherosLectura;

public class EntradaDos {

    public static void main(String[] args) {
        GestorFicherosLectura gestorFicherosLectura = new GestorFicherosLectura();
       // gestorFicheros.lecturaDirectorios("src/resources/directorio");
       // gestorFicheros.lecturaDirectorios("src/resources/ficheros");

       // gestorFicheros.lecturaRecursiva("C:\\Users\\Sikem\\Documents");
        gestorFicherosLectura.lecturaTextoPlano("src/resources/ficheros/lectura.txt");
    }

}
