package controller;
import java.io.*;

public class GestorFicherosLectura {

    public void lecturaDirectorios(String path){
        // File (logico) -> apunta a un file (fisico)
        File file = new File(path);
        String[] nombres = file.list();
        File[] ficheros =file.listFiles();

        for(File item : ficheros){
            //if(!item.isHidden()) { --> solo muestra los ficheros NO ocultos
                System.out.println(item.getName());
                if(item.isDirectory()){
                    File[] subdirectorio = item.listFiles();
                    for(File file1:subdirectorio){
                        System.out.println("\t"+file1.getName());  //el \t es un tabulado en consola
                    }
                }
            //}
        }

        /*for(String item : nombres){
            if (!(item.charAt(0) == '.')) {
                System.out.println(item);
            }
        }*/
    }

    public void lecturaRecursiva(String path){
        File file =new File(path);

        File[] ficheros = file.listFiles();

        for(File item: ficheros){
            System.out.println(item.getName());
            if(item.isDirectory()){
                lecturaSubdirectorios(item);
            }

            //Preguntamos si es directorio
                // si lo es, sacamos todos los ficheros del directorio y los muestro --> sin saber cuantas veces preguntamos (niveles de carpetas)
                //se usa la recursividad -> ejecucion que se llama a sí misma, TIENE QUE TENER UNA SALIDA
        }
    }

    private void lecturaSubdirectorios(File fichero){
        for(File file: fichero.listFiles()){
            System.out.println("\t"+file.getName());
            if(file.isDirectory()){
                lecturaSubdirectorios(file);
            }
        }
    }


    public void lecturaTextoPlano(String path){
        //FILE --> FILEREADER -> BUFFEREDREAD--> cuando terminan los flujos de datos, hay que cerrarlos (finally)
        File file = new File(path);
       //FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        if(file.exists() && file.isFile()){ //Existe y ademas es un Fichero
            //Tratatamos la excepcion aqui - manera 1
            try {
                //fileReader = new FileReader(file); // Tiene una excepción, se puede tratar justo antes o arriba
                bufferedReader = new BufferedReader(new FileReader(file));
                String lectura = null;
                //StringBuffer lecturaCompleta = new StringBuffer(); -> es sincronizado (si tiene
                // varios hilos se comuncan entre ellos para decir quien tiene el objeto ocupado)

                StringBuilder lecturaCompleta = new StringBuilder(); // solo utiliza 1 hilo

                while ((lectura = bufferedReader.readLine())!= null){
                    lecturaCompleta.append(lectura);
                    lecturaCompleta.append("\n");
                }
                System.out.println(lecturaCompleta);
               // int lectura = 0; // devuelve int -> UNICODE ASCI
                // mientras exista un número haz la lectura e imprime

                System.out.println(bufferedReader.readLine());

                /*while((lectura=fileReader.read()) != -1){ // LECTURA CON FILEREADER
                    //imprime
                    System.out.println((char)lectura);
                }*/
            }  catch (FileNotFoundException e){
                System.out.println("Fallo en la lectura del fichero");
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println("Fallo en la escritura");
            } finally {
                //el bloque finally se ejecuta SI O SI independientemente si entra en try o catch
                try {
                    bufferedReader.close(); //Si entra por el catch, el fileReader es null (nullpointerexception)
                } catch (IOException e){  //se puede poner IOException | NullPointerException e / tambien Exception (generica)
                    System.out.println("Error en el cerrado del flujo");
                } catch (NullPointerException e){
                    System.out.println("Error en el cerrado por ser nulo");
                }
            }

            //Excepcion - manera 2
            //fileReader=new FileReader(file);
        }
    }

}
