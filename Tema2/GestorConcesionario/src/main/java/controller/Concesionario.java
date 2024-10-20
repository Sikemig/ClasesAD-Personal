package controller;

import com.mysql.cj.protocol.Resultset;
import database.DbConnection;
import database.SchemaDB;
import model.Empleado;

import java.sql.*;

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

            /*String query = String.format("INSERT INTO %s (%s,%s,%s,%s) VALUES ('%s', '%s', '%s', %d)",
                    SchemaDB.TAB_EMP,
                    SchemaDB.COL_EMP_NAME, SchemaDB.COL_EMP_SURNAME, SchemaDB.COL_EMP_MAIL, SchemaDB.COL_EMP_PHO,
                    empleado.getNombre(), empleado.getApellido(), empleado.getCorreo(), empleado.getTelefono());

            statement.execute(query); // hay o no fallo
            */



            String Psquery = String.format("INSERT INTO %s (%s,%s,%s,%s,%s) VALUES (?,?,?,?,?)",
                    SchemaDB.TAB_EMP,
                    SchemaDB.COL_EMP_NAME, SchemaDB.COL_EMP_SURNAME, SchemaDB.COL_EMP_MAIL, SchemaDB.COL_EMP_PHO, SchemaDB.COL_EMP_KIN,
                    empleado.getNombre(), empleado.getApellido(), empleado.getCorreo(), empleado.getTelefono());

            PreparedStatement preparedStatement = connection.prepareStatement(Psquery);
            preparedStatement.setString(1, empleado.getNombre());
            preparedStatement.setString(2, empleado.getApellido());
            preparedStatement.setString(3, empleado.getCorreo());
            preparedStatement.setInt(4, empleado.getTelefono());
            preparedStatement.setInt(5, empleado.getTipo().getId());
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

    public void leerUsuarios(int tipo){
        //No se puede mapear de forma directa -> Vectores[[nombre, apellidos, correo], [nombre, apellidos, correo],[nombre, apellidos, correo]]
        // Connection -> Statement / PrepareStatement -> metodo executeQuery que devuelve un ResultSet

        Connection connection = new DbConnection().getConnection();

        //SELECT * FROM empleado WHERE ID = 1;
        String query = String.format("SELECT * FROM %s WHERE %s=?", SchemaDB.TAB_EMP, SchemaDB.COL_EMP_KIN);
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,tipo);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){ // Devuelve 1 solo resultado, así que bucle
                String nombre = resultSet.getString(SchemaDB.COL_EMP_NAME);
                String correo = resultSet.getString(SchemaDB.COL_EMP_MAIL);
                int tipo1 = resultSet.getInt(SchemaDB.COL_EMP_KIN);
                System.out.printf("Nombre del empleado: %s\n\tCorreo del empleado %s\n\tTipo del empleado %s\n", nombre, correo, tipo1);
            }
        } catch (SQLException e) {
            System.out.println("Error en la query");
        }

    }
}
