import model.Producto;

public class Entrada {
    public static void main(String[] args) {
        GestorFicheros gestorFicheros = new GestorFicheros();
        //gestorFicheros.escribirBinarios("src/main/java/resources/datos.bin");
        //gestorFicheros.lecturaBinarios("src/main/java/resources/datos.bin");

        //gestorFicheros.escribirObjeto("src/main/java/resources/objetos.obj");

        //gestorFicheros.escribirObjeto("src/main/java/resources/objetos_serializados.obj");
        //gestorFicheros.escribirObjeto("src/main/java/resources/almacen.obj");

        gestorFicheros.lecturaObjeto("src/main/java/resources/almacen.obj");
        //gestorFicheros.lecturaObjeto("src/main/java/resources/objetos_serializados.obj");

        //Producto producto = new Producto(1, "asdjnh", 12.31, 20); // Caracteristicas del objeto
                                                                                        // UID del producto
    }
}
