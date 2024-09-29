package controller;

import java.io.*;
import java.util.Scanner;

public class GestorFicherosCombinado {

    public void lecturaEscritura(String path){
        Scanner scanner = new Scanner(System.in);
        File file = new File(path);
        FileWriter fileWriter = null;

        System.out.println("Introduce el mensaje a guardar");
        String mensaje = scanner.nextLine();
        System.out.println("Por favor, indica la fase de cifrado");
        int fase = scanner.nextInt();

        try {
            fileWriter = new FileWriter(file, false); //importante fuera del for porque con append false nos lo machacaria constantemente
            for (int i = 0; i < mensaje.length() ; i++) {
                char letra = mensaje.charAt(i);
                //fileWriter.write(letra+"\n");
                int codigo = (int) letra;
                char codigoLetra = (char)(codigo*fase);
                fileWriter.write(codigoLetra);
                //fileWriter.write(String.valueOf((codigo*fase)+"\n")); //con String.valueOf hacemos que lo que escribamos lo pase a ASCII
            }
        } catch (IOException e) {
            System.out.println("Error en los permisos");
        } finally {
            try {
                fileWriter.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Fallo en el cerrado del flujo");
            }
        }

    }

    public void lecturaCifrada(String path){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor indica la fase de descifrado");
        int fase = scanner.nextInt();

        File file = new File(path);
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String lectura = null;
            StringBuffer lecturaCompleta = new StringBuffer();

            while ((lectura = bufferedReader.readLine())!= null){
                int codigo = Integer.parseInt(lectura);
                System.out.println((char)(codigo/fase));
            }
            System.out.println(lecturaCompleta);

        } catch (IOException e) {
            System.out.println("Fallo al leer el fichero");
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println("Fallo al cerrar el flujo");
            }
        }
    }


    public void lecturaCifradaCodigo(String path){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor indica la fase de descifrado");
        int fase = scanner.nextInt();

        File file = new File(path);
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String lectura = null;
            StringBuffer lecturaCompleta = new StringBuffer();

            while ((lectura = bufferedReader.readLine())!= null){
                lecturaCompleta.append(lectura);
            }
            System.out.println(lecturaCompleta);

            for (int i = 0; i < lecturaCompleta.length(); i++) {
                int codigo = (int)lecturaCompleta.charAt(i)/fase;
                System.out.println((char) codigo);
            }

        } catch (IOException e) {
            System.out.println("Fallo al leer el fichero");
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println("Fallo al cerrar el flujo");
            }
        }
    }
}
