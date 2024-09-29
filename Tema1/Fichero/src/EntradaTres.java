import controller.GestionFicherosEscritura;
import controller.GestorFicherosCombinado;

import java.util.Scanner;

public class EntradaTres {

    public static void main(String[] args) {

        GestionFicherosEscritura gestionFicherosEscritura = new GestionFicherosEscritura();
        //gestionFicherosEscritura.escribirFichero("src/resources/ficheros/escritura.txt"); //para un fichero concreto
        //gestionFicherosEscritura.escribirFichero("src/resources/ficheros/"); //para un fichero desconocido

        GestorFicherosCombinado gestorFicherosCombinado = new GestorFicherosCombinado();

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("Introduce que quieres hacer");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    gestorFicherosCombinado.lecturaEscritura("src/resources/ficheros/cifrado.txt");
                    break;
                case 2:
                    gestorFicherosCombinado.lecturaCifradaCodigo("src/resources/ficheros/cifrado.txt");
                    break;
            }
        } while (opcion!=0);
    }

}
