package controller;

import database.DbConnection;
import database.SchemaDB;
import model.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Concesionario {
    //Statement -> query "directa" -> insert into empleados (nombre,apellido,correo,telefono) values ('Sikem', 'Iglesias', 'sikem@gmail.com', 1234)
            // da true o false -> se crea
            // nº de filas afectadas --> se updatea o se deletea

    //PrepareStatement -> query con "template" -> insert into empleados (nombre,apellido,correo,telefono) values (?,?,?,?)
    // setInt(4, 1234)
    // setString (1, "Sikem");
    // setString (2, "Iglesias");
    // setString (1, "sikem@gmail.com");



    //create update delete  --> modifican la tabla               CRUZ
    //read --> obtiene un vector de valores                     CRUZ

    //insertar trabajador
    public void insertarTrabajador(Empleado empleado){
        // 1º con Statement
        // Connection -> Statement (query) -> metodo .execute o update


        // Conexion de la clase DbConnection
        Connection connection = new DbConnection().getConnection();

        //A partir de aqui ya estamos conectados a la BBDD
        try {
            Statement statement = connection.createStatement();

            String query = String.format("INSERT INTO %s (%s,%s,%s,%s) VALUES ('%s', '%s', '%s', %d)",
                    SchemaDB.TAB_EMP,
                    SchemaDB.COL_EMP_NAME, SchemaDB.COL_EMP_SURNAME, SchemaDB.COL_EMP_MAIL, SchemaDB.COL_EMP_PHO,
                    empleado.getNombre(), empleado.getApellido(), empleado.getCorreo(), empleado.getTelefono());

            statement.execute(query); // hay o no fallo




            String Psquery = String.format("INSERT INTO %s (%s,%s,%s,%s) VALUES (?,?,?,?)",
                    SchemaDB.TAB_EMP,
                    SchemaDB.COL_EMP_NAME, SchemaDB.COL_EMP_SURNAME, SchemaDB.COL_EMP_MAIL, SchemaDB.COL_EMP_PHO,
                    empleado.getNombre(), empleado.getApellido(), empleado.getCorreo(), empleado.getTelefono());

            PreparedStatement preparedStatement = connection.prepareStatement(Psquery);
            preparedStatement.setString(1, "SikemPS");
            preparedStatement.setString(2, "IglesiasPS");
            preparedStatement.setString(3, "sikemPS@gmail.com");
            preparedStatement.setInt(4, 122344);
            preparedStatement.executeUpdate();
            //preparedStatement.executeUpdate();

            // la query sería asi pero es inviable
            /*String query = "INSERT INTO"+SchemaDB.TAB_EMP+" ("+SchemaDB.COL_EMP_NAME+","+SchemaDB.COL_EMP_SURNAME+","+SchemaDB.COL_EMP_MAIL+","+SchemaDB.COL_EMP_PHO+") " +
                    "Values ('"+empleado.getNombre()+"','"+empleado.getApellido()+"','"+empleado.getCorreo()+"','"+empleado.getTelefono())"*/

            // mejor asi
            // %s -> string
            // %d -> int
            // %f -> double o float
            // %b --> boolean
            // %c --> char

            // statement.executeUpdate(); // nos dice cuantas filas estan afectadas
        } catch (SQLException e) {
            System.out.println("Error en la conexion de la BBDD");
        }

    }

    public int borrarUsuario(int id){
        Connection connection = new DbConnection().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM "+SchemaDB.TAB_EMP+" WHERE id=?");
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en la creacion de la query");
        }

        return 0;
    }
}
