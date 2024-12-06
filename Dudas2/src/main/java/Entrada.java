import dao.UsuarioDAO;
import database.DataBaseConnection;
import model.Usuario;

import java.sql.SQLException;
import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Logica de la APP
        /*try {
            if(!usuarioDAO.insertUser(new Usuario("sikem", "iglesias", "sikemig@unir.es", "2323"))){
                System.out.println("Usuario insertado con exito");
            } else {
                System.out.println("Fallo en el proceso de insercion");
            }
        } catch (SQLException e) {
            System.out.println("Error en la ejecucion, es posible que el correo ya exista, quieres volver a probar?");
        }*/


        /*try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Indica el correo que quieres borrar");
            String correo = scanner.next();

            int deleteRows = usuarioDAO.deleteUser(correo);
            System.out.println("El numero de elementos borrados es " + deleteRows);
        } catch (SQLException e) {
            System.out.println("Error en la ejecución");
        }*/

        /*try {
            for(Usuario item: usuarioDAO.getAllUsers()){
                // sacarla en un informe - JAVAMAIL
                item.getCorreo();
            }
        } catch (SQLException e) {
            System.out.println("Error en la ejecucion");
        }*/

        boolean login = false;

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Indicame el correo");
            String correo = scanner.next();
            System.out.println("Indicame la pass");
            String pass = scanner.next();

            try {
                login = usuarioDAO.getLogin(correo, pass);
                if (login ) {
                    System.out.println("Login correcto");
                } else {
                    System.out.println("Login incorrecto");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }while (!login);
    }
}
