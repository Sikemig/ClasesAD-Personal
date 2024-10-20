package controller;

import model.Usuario;

import java.io.*;

public class GestionFlujos {

    // SE REQUIERE SIEMPRE DE UN FILE --> Fichero con el que se va a trabajar
    private static File file = new File("src/main/java/resources/ejemplo.txt");
    private static File fileBinario = new File("src/main/java/resources/ejemplo.bin");
    private static File fileObjeto = new File("src/main/java/resources/ejemplo.obj");


    //TEXTO PLANO --> nos guarda un .txt
    public void escrituraTP(){
        // Escritura -> Output -> Writer
        // File --> FileWriter
        // File --> FileWriter --> BufferWriter
        // File --> FileWriter --> PrintWriter
        // 1 --> FileWriter fileWriter = null;
        // 2 --> BufferedWriter bufferedWriter = null;
        PrintWriter printWriter = null;
        try {
            /* 1 --> fileWriter = new FileWriter(file, true);
            fileWriter.write("Esto es un ejemplo de escritura\n");
            fileWriter.write("Esto es un ejemplo de escritura\n");
            fileWriter.write("Esto es un ejemplo de escritura\n");
            fileWriter.write("Esto es un ejemplo de escritura\n"); */

            /* 2 --> bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            bufferedWriter.write("Esto es una linea con bufferedWriter");
            bufferedWriter.newLine(); */

            printWriter = new PrintWriter(new FileWriter(file, true));
            printWriter.println("Esta linea va con PrintWriter");

        } catch (IOException e) {
            System.out.println("Error en la puesta en escritura del fichero");
        } finally {
            try {
                // 1 --> fileWriter.close();
                // 2 --> bufferedWriter.close();
                printWriter.close(); // No necesita el IOException
            } catch (NullPointerException e) {
                System.out.println("Error al cerrar el fichero");
            }
        }
    }

    public void lecturaTP(){
        //File
        // File -> FileReader -> lectura caracter a caracter (char)
        // File -> FileReader -> BufferedReader -> linea a linea (hasta encontrar salto de linea)
        // 1 --> FileReader fileReader = null;

        BufferedReader bufferedReader = null;

        try {
            /* 1 --> fileReader = new FileReader(file);
            int lectura = -1;

            while( (lectura = fileReader.read()) != -1) { // devuelve el caracter leido o -1 para parar de leer con lo que hay que meterlo en un while
                System.out.print((char)lectura);
            } */

            bufferedReader = new BufferedReader(new FileReader(file)); // al igual que el filereader, hay que reiterar para que lea mas de 1 linea, otro while
            String linea = null;
            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el fichero");
        } catch (IOException e) {
            System.out.println("Error en la lectura");
        } finally {
            try {
                // 1 --> fileReader.close();
                bufferedReader.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado");
            }
        }
    }

    //BINARIO --> nos guarda un tipo de dato (5 , false "String")
    public void lecturaBinarios(){
        // File --> Filereader -> bufferedreader
        // File --> FileInput -> DataInputStream

        DataInputStream dataInputStream = null;

        try {
            dataInputStream = new DataInputStream(new FileInputStream(fileBinario));
            char letra = dataInputStream.readChar();
        } catch (FileNotFoundException e) {
            System.out.println("Error en la ruta del fichero");
        } catch (IOException e) {
            System.out.println("Error en la lectura");
        } finally {
            try {
                dataInputStream.close();
            } catch (IOException e) {
                System.out.println("Error en el cerrado");
            }
        }
    }

    public void escrituraBinarios(){
        // File -> FileWritter-> BufferedWriter
        // File -> FileOutPut -> DataOutputStream

        DataOutputStream dataOutputStream = null;

        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream(fileBinario));
            dataOutputStream.writeUTF("Esto es un ejemplo de binario");
        } catch (FileNotFoundException e) {
            System.out.println("Error en la ruta del fichero");
        } catch (IOException e) {
            System.out.println("Error en la escritura");
        } finally {
            try {
                dataOutputStream.close();
            } catch (IOException e) {
                System.out.println("Error en el cerrado");
            }
        }
    }

    // OBJETO --> guarda un objeto (asd,asd,ad)
    public void lecturaObjetos(){
        // File -> FileInputStream -> ObjectInputStream

        ObjectInputStream objectInputStream = null;

        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(fileObjeto));

            Object recuperado = null;
            while ((recuperado = objectInputStream.readObject()) != null){
                System.out.println(((Usuario)recuperado).getNombre());
            }

        } catch (IOException e) {
            System.out.println("Error en la lectura");
        } catch (ClassNotFoundException e) {
            System.out.println("No se encuentra la clase relacionada");
        } finally {
            try {
                objectInputStream.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado");
            }
        }
    }

    public void escrituraObjetos(){
        // File -> FileOutputStream -> ObjectOutputStream

        ObjectOutputStream objectOutputStream= null;

        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileObjeto));
            objectOutputStream.writeObject(new Usuario("Sikem" , "iglesias", "holiwi"));
            objectOutputStream.writeObject(new Usuario("Sikem" , "iglesias", "holiwi"));
            objectOutputStream.writeObject(new Usuario("Sikem" , "iglesias", "holiwi"));
            objectOutputStream.writeObject(new Usuario("Sikem" , "iglesias", "holiwi"));
            objectOutputStream.writeObject(new Usuario("Sikem" , "iglesias", "holiwi"));
            objectOutputStream.writeObject(new Usuario("Sikem" , "iglesias", "holiwi"));
        } catch (IOException e) {
            System.out.println("Error en la escritura");
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                System.out.println("Error en el cerrado");
            }
        }
    }

}
