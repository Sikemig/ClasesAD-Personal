import controller.Concesionario;
import database.DbConnection;
import model.Empleado;

import java.sql.Connection;

public class Entrada {
    public static void main(String[] args) {

        DbConnection dbConnection = new DbConnection();
        Connection connection = dbConnection.getConnection();

        //Recomendable cerrar conexión cuando acabes de trabajar
        /*dbConnection.closeConnection();

        DbConnection dbConnection2 = new DbConnection();
        Connection connection2 = dbConnection2.getConnection();*/


//        Concesionario concesionario = new Concesionario();
  //      concesionario.insertarTrabajador(new Empleado("Sikem,", "Iglesias", "sikem@gmail.com", 123));

        //System.out.println("Filas afectadas: "+concesionario.borrarUsuario(2));
    }
}
