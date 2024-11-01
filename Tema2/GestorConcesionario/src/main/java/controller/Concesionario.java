package controller;

import com.mysql.cj.protocol.Resultset;
import dao.CochesDAO;
import dao.EmpleadoDAO;
import dao.VentaDAO;
import database.DbConnection;
import database.SchemaDB;
import model.Coche;
import model.Empleado;

import java.sql.*;
import java.util.Scanner;

public class Concesionario {
    private EmpleadoDAO empleadoDAO;
    private CochesDAO cochesDAO;
    private VentaDAO ventaDAO;

    public Concesionario(){
        empleadoDAO = new EmpleadoDAO();
        cochesDAO = new CochesDAO();
        ventaDAO = new VentaDAO();
    }

    public void insertarTrabajadorDAO(Empleado empleado){
        //la logica del negocio
        try {
            empleadoDAO.insertarEmpleado(empleado);
        } catch (SQLException e) {
            System.out.println("Error en la insercion del empleado");
        }
    }


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

    public void agregarCoche(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce marca");
        String marca = scanner.next();
        System.out.println("Introduce modelo");
        String modelo = scanner.next();
        System.out.println("Cuantos cv tiene");
        int cv = scanner.nextInt();
        System.out.println("Introduce precio");
        int precio = scanner.nextInt();

        // si me dicen una marca y ya tengo 8 coches de esa marca no lo quiero comprar

        try {
            if(cochesDAO.getModeloCochesMarca(marca).size()<2) {
                cochesDAO.addCoche(new Coche(marca, modelo, cv, precio));
                System.out.println("Coche añadido correctamente");
            } else{
                System.out.println("No interesa el coche al concesionario");
            }

        } catch (SQLException e) {
            System.out.println("La base de datos no esta disponible, quierees guardar el objeto para mas adelante?");
            // guardar datos en un fichero

        }
    }

    public void filtrarPrecio(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por que precio quieres filtrar");
        int precio = scanner.nextInt();

        try {
            for(Coche coche : cochesDAO.getCochePrecio(precio)){
               //Mostrar los datos en la consola
                coche.mostradDatos();
            }

        } catch (SQLException e) {
            System.out.println("No se puede realizar la consulta, quieres hacer otra cosa?");
        }
    }


    // tener la funcionalidad de vender un coche -> matricula
    // y el coche lo vende un vendedor (tengo que decir quien lo vende)
    // hay que tener la funcionalidad de cual es el vendedor que más coches ha vendido
    public void realizarVenta(){
        System.out.println("Dime el coche que vas a vender");
        //Pedir el id por scanner
        int idCoche=0;

        System.out.println("Dime el vendedor del coche");
        int idEmpleado=0;

        try {
            // el coche que estas vendiendo está disponible?
                // si no esta disponible haz XXXX
                    // buscar un coche con las mismas caracteristicas de cv y precio
                // si está disponible, procede a registrar la venta
                    //cochesDAO.realizarVenta(1);
                    //empleadoDAO.realizarVenta(1);
            ventaDAO.realizarVenta(idEmpleado,idCoche);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarEmpleadosMes(int numero){
        System.out.println("Dime cuantos quierees sacar");
        //int numeroEmpleados= 0;
        try {
            empleadoDAO.obtenerEmpleadoMes(3);
        } catch (SQLException e) {
            System.out.println("Error a la hora de obtener los empleados, quieres hacer XXX?");
        }

    }
}
