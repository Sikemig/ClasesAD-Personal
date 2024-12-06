package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static Connection connection;

    // la Connection es privada para que no la cojan sin querer, se les da indirectamente con getters y setters


    public void createConnection() throws SQLException {
        // jdbd:mysql://localhost:port/database
        String url = String.format("jdbc:mysql://%s:%s/%s",
                DBScheme.HOST, DBScheme.PORT, DBScheme.DATABASE);

        connection = DriverManager.getConnection(url,"root","");
    }


    public Connection getConnection(){
        // Cabe la posibilidad de que connection sea null, entonces
        if (connection == null){
            try {
                createConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    public void closeConnection(){
        try {
            connection.close();
            connection = null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
