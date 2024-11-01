package dao;

import com.mysql.cj.protocol.Resultset;
import database.DbConnection;
import database.SchemaDB;
import model.Coche;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// Clase destinada a la gestion de los coches contra la BD -> querys
public class CochesDAO {

    private Connection connection;

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public CochesDAO(){
        connection = new DbConnection().getConnection();
    }

    // Metodos necesarios, añadir, consultar, borrar

    public void addCoche(Coche coche) throws SQLException {
        String query = String.format("INSERT into %s (%s,%s,%s,%s) VALUES (?,?,?,?)",
                SchemaDB.TAB_COC, SchemaDB.COL_COC_MAR, SchemaDB.COL_COC_MOD, SchemaDB.COL_COC_CV, SchemaDB.COL_COC_PRE);

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, coche.getMarca());
        preparedStatement.setString(2, coche.getModelo());
        preparedStatement.setInt(3, coche.getCv());
        preparedStatement.setInt(4, coche.getPrecio());

        preparedStatement.execute();
    }

    public ArrayList<Coche> getModeloCochesMarca(String marcaParam) throws SQLException {

        String query = String.format("SELECT * FROM %s WHERE %s=?",
              SchemaDB.TAB_COC, SchemaDB.COL_COC_MAR);

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,marcaParam);

        resultSet = preparedStatement.executeQuery();

        return getResultados(resultSet);
    }

    public ArrayList<Coche> getCochePrecio(int precioParam) throws SQLException {
        String query = String.format("SELECT * FROM %s WHERE %s<=?",
                SchemaDB.TAB_COC, SchemaDB.COL_COC_PRE);

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,precioParam);
        resultSet = preparedStatement.executeQuery();

        return getResultados(resultSet);
    }

    private Coche mapearCoche(String marca, String modelo, int cv, int precio){
        return new Coche(marca,modelo,cv,precio);
    }

    private ArrayList<Coche> getResultados(ResultSet datosResultantes) throws SQLException {
        ArrayList<Coche> listaResultado = new ArrayList<>();

        while (datosResultantes.next()){
            String marca = resultSet.getString(SchemaDB.COL_COC_MAR);
            String modelo = resultSet.getString(SchemaDB.COL_COC_MOD);
            int cv = resultSet.getInt(SchemaDB.COL_COC_CV);
            int precio = resultSet.getInt(SchemaDB.COL_COC_PRE);

            listaResultado.add(mapearCoche(marca,modelo,cv,precio)); // metodo de debajo, por si lo usamos mas
            // es lo mismo que listaResultado.add(new Coche(marca,modelo,cv,precio));
        }
        return listaResultado;
    }

    public void realizarVenta(int id){
        // DELETE -> WHERE ID = id  / para borrarlo

        //UPDATE -> estado = false where id = id / para mantener un registro en la BBDD
    }
}
