import database.DbConnection;

import java.sql.Connection;

public class Entrada {
    public static void main(String[] args) {

        DbConnection dbConnection = new DbConnection();
        Connection connection = dbConnection.getConnection();

        //Recomendable cerrar conexión cuando acabes de trabajar
        dbConnection.closeConnection();

        DbConnection dbConnection2 = new DbConnection();
        Connection connection2 = dbConnection2.getConnection();

    }
}
