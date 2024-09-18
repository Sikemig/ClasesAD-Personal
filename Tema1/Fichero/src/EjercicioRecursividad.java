import java.io.File;

public class EjercicioRecursividad {

    public static void main(String[] args) {
        //Ejercicio 1 - Listar el nombre de todos los ficheros ubicados en un directorio (carpeta ficheros)
        File ficherosDeDirectorio1 = new File("src/resources/ficheros");
        File[] listado1 = ficherosDeDirectorio1.listFiles();

        for(int x=0; x<listado1.length; x++){
            System.out.println("Este es el listado de los ficheros de una carpeta (ejercicio 1): " + listado1[x].getName());
        }


        //Ejercicio 2 - Crear un subdirectorio dentro de la carpeta anterior y listar el nombre de los archivos
        File ficherosDeDirectorio2 = new File("src/resources/ficheros/directorio");
        File[] listado2 = ficherosDeDirectorio2.listFiles();

        for(File list:listado2){
            System.out.println("Este es el resultado de la subcarpeta (ejercicio 2): " + list.getName());
        }

        //Ejercicio 3 - Listar el nombre de todos los ficheros y directorios de una ruta concreta, como por ejemplo C:/Users
        File ficherosDeDirectorio3 = new File("C:\\Users");
        File[] listado3 = ficherosDeDirectorio3.listFiles();


      for(File list:listado3){
            System.out.println("Este es el listado de ficheros y directorios de Users (ejercicio 3): " + list.getName());
        }

    }
}
