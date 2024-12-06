package database;

public interface DBScheme {
    // Elemento que interconecta cosas que no tienen que ver entre si
    // La clase y sus metodos son abstractos

    public final static String HOST = "127.0.0.1";

    String PORT = "3306";

    String DATABASE = "repaso";

    String TAB_USER ="usuarios";

    String COL_ID = "id";
    String COL_NAME = "nombre";
    String COL_SURNAME = "apellido";
    String COL_PASS = "password";
    String COL_MAIL = "correo";
}
