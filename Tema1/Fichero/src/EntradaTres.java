import controller.GestionFicherosEscritura;
import controller.GestorFicherosCombinado;

public class EntradaTres {

    public static void main(String[] args) {

        GestionFicherosEscritura gestionFicherosEscritura = new GestionFicherosEscritura();
        //gestionFicherosEscritura.escribirFichero("src/resources/ficheros/escritura.txt"); //para un fichero concreto
        //gestionFicherosEscritura.escribirFichero("src/resources/ficheros/"); //para un fichero desconocido


        GestorFicherosCombinado gestorFicherosCombinado = new GestorFicherosCombinado();
        gestorFicherosCombinado.lecturaEscritura("src/resources/ficheros/cifrado.txt");

        gestorFicherosCombinado.lecturaCifrada("src/resources/ficheros/cifrado.txt");
    }

}
