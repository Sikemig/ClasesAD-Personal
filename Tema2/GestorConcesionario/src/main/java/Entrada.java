import controller.Concesionario;
import database.DbConnection;
import model.Empleado;
import model.Tipo;

import java.sql.Connection;

public class Entrada {
    public static void main(String[] args) {
        // TIPO 1, EXT
        // TIPO 2, IND
        // TIPO 3, BEC
        // Para poder pasar un TIPO a trabajador en una lista cerrada hay que usar ENUM

        /*DbConnection dbConnection = new DbConnection();
        Connection connection = dbConnection.getConnection();*/

        //Recomendable cerrar conexión cuando acabes de trabajar
        /*dbConnection.closeConnection();

        DbConnection dbConnection2 = new DbConnection();
        Connection connection2 = dbConnection2.getConnection();*/


        Concesionario concesionario = new Concesionario();
        //concesionario.insertarTrabajador(new Empleado("Sikem2", "Iglesias2", "sikem@gmail.com2", 1232, Tipo.INDEFINIDO));

        //System.out.println("Filas afectadas: "+concesionario.borrarUsuario(2));

        concesionario.leerUsuarios(2);
    }
}
