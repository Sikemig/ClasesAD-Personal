import java.io.File;
import java.io.IOException;

public class Entrada {

    public static void main(String[] args) {
        //FILE -> fichero logico -> fisico
        //fichero logico
        //File ficheroSinPuntero new File(pathname:"");
        File ficheroSinPuntero = new File("C:\\Users\\Sikem\\Desktop\\FP DAM UNIR CURSO\\2º DAM\\Acceso a datos\\ClasesAD-Personal\\Tema1\\Fichero\\src\\resources\\directorio\\ejemplo_fichero.md");


        System.out.println(ficheroSinPuntero.getName());
        System.out.println(ficheroSinPuntero.getParent());
        System.out.println(ficheroSinPuntero.length());
        System.out.println(ficheroSinPuntero.exists());
        System.out.println(ficheroSinPuntero.isDirectory());

        // File[] -> todos los FICHEROS que estan dentro del directorio
        ficheroSinPuntero.listFiles();

        // String[] -> todas las rutas de los FICHEROS que estan dentro del directorio
        ficheroSinPuntero.list();

        // 1 -> obtener los nombres de los ficheros del directorio llamado directorio
        // 2-> Crear una subcarpeta en el directorio llamado directorio y crear en ella un fichero
        // -> obtener los nombres de los ficheros del directorio llamado directorio y el subdirectorio
        // 3 -> listar el nombre de todos los ficheros del SISTEMA (C:/Users)

        // RECURSIVIDAD

        if (!ficheroSinPuntero.exists()){
            try {
                ficheroSinPuntero.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
