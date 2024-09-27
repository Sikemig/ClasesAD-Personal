package controller;

import java.io.*;
import java.util.Scanner;

public class GestionFicherosEscritura {

    private int contador=0; // para fichero correlativo

    public void escribirFichero(String path) {
        Scanner scanner = new Scanner(System.in); //para recoger por teclado
       // contador++;
       // path +="_escritura"+contador+".txt"; //para el fichero correlativo

        //FILE -> FILEWRITER -> BUFFEREDWRITER -> PRINTWRITER -> CERRAR

       // System.out.println("Cual es el nombre del fichero a guardar");
        //String nombre = scanner.next();
        //File file = new File(path+nombre+".txt");

        File file = new File(path+"ejemplo.txt");
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        PrintWriter printWriter = null; // el PrintWriter NO necesita cerrar el flujo de datos

        //System.out.println("Por favor lo que quieres guardar en el fichero");
        //String lecturaFrase = scanner.nextLine();
       // System.out.println("Indica si quieres anexar la frase al fichero");
        //boolean sobrescritura = scanner.nextBoolean();

        try {
            fileWriter= new FileWriter(file, true); //append -> se usa para anexar o no la escritura
            //bufferedWriter = new BufferedWriter(fileWriter);
            //fileWriter.write(lecturaFrase); //si ponemos número sin string, nos escribe el numero ASCII
           // bufferedWriter.newLine(); // para un intro en la escritura
            //bufferedWriter.write("Escritura de segunda linea con bufferedwriter");
            printWriter= new PrintWriter(file); //printWriter no tiene append, si hay que mantener algo hay que leerlo primero
            printWriter.println("Linea escrita con un printWriter");
            printWriter.println("Segunda linea escrita con un printWriter");
        } catch (IOException e) {
            System.out.println("Error en la escritura del fichero, por falta de permisos");
        } finally {
            try {
                //fileWriter.close(); //Aqui cierras el flujo
                //bufferedWriter.close();  // cerrando el ultimo se cierran todos los anteriores
                printWriter.close(); // NO ES OBLIGATORIO
            } catch (NullPointerException e) {
                System.out.println("Error en el cierre del flujo");
            }
        }

    }

}
