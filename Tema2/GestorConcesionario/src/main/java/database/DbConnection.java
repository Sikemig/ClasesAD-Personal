package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static Connection connection;


    public Connection getConnection(){

        if (connection==null){ // si no esta creada --> la creo
            newConnection();
        }
        // si esta creada --> se la doy
        return connection;
    }

    private void newConnection() {
        // necesitamos URL de conexión --> jdbc:mysql://localhost o 127.0.0.1:3306 o el DNS/concesionario - mysql en nuestro caso
        String url = "jdbc:mysql://localhost:3306/concesionario";

        try {
            connection = DriverManager.getConnection(url, "root", "");
        } catch (SQLException e) {
            System.out.println("Error en la conexión de la BBDD");
        }
        System.out.println("Conexion creada correctamente");
    }

    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión");
        }finally{
            connection = null;
        }
    }
}
