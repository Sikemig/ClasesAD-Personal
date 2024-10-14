package database;

public interface SchemaDB {

    //1. una interfaz es para conectar 2 clases que no tienen nada que ver
    // con los metodos abstractos que tiene dicha interfaz

    //2. tambien sirven como almacen de constantes variables --> finales (NO de metodos)

    // no hace falta poner el public y el abstract, al ser interfaz se supone
    // el public final es redundante tambien

    String DB_NAME = "concesionario";
    String TAB_EMP = "empleados";
    String COL_ID = "id";
    String COL_EMP_NAME = "nombre";
    String COL_EMP_SURNAME = "apellido";
    String COL_EMP_MAIL = "correo";
    String COL_EMP_PHO = "telefono";
}
