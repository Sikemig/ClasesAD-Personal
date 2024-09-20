package controller;
import java.io.File;

public class GestorFicheros {

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
}
