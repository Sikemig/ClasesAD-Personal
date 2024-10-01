package resources;

import java.util.Scanner;

public class EntradaEjercicio {
    public static void main(String[] args) {
        EjercicioJson ejercicioJson = new EjercicioJson();

        // Ponemos un menú
        int opcion = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, introduce la opción que desea hacer: ");
        System.out.println("1 para ver el Nombre, precio, stock y descripcion de los productos");
        System.out.println("2 para buscar un producto por ID");
        System.out.println("3 para buscar productos por precio");
        System.out.println("4 para exportar todos los productos a un .txt");
        System.out.println("0 para salir");

        do{
            System.out.println("Introduzca la opción");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    ejercicioJson.peticionJSON();
                    break;
                case 2:
                    ejercicioJson.lecturaID();
                    break;
                case 3:
                    ejercicioJson.lecturaPrecio();
                    break;
                case 4:
                    ejercicioJson.exportar();
                    break;
            }
        } while (opcion!=0);
        System.out.println("Fin de programa");
    }
}
