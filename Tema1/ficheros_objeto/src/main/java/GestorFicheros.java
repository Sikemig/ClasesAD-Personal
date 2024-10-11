import model.Producto;
import model.Tienda;

import java.io.*;

public class GestorFicheros {

    public void escribirBinarios(String path){
        //File
        File file = new File(path);

        DataOutputStream dataOutputStream = null;

        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            dataOutputStream.writeUTF("Esto es un ejemplo");
            dataOutputStream.writeInt(5);
            // 0x0A en el archivo -> byte en la posicion de memoria
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeChar(234);

        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Problema con el fichero");
        }finally {
            try {
                dataOutputStream.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error al cerrar");
            }
        }
    }

    public void lecturaBinarios(String path){
        //File
        File file = new File(path);

        DataInputStream dataInputStream = null;

        try {
            dataInputStream = new DataInputStream(new FileInputStream(file));

            // chars
            String lectura = dataInputStream.readUTF();
            System.out.println(lectura);
            // int
            int numero = dataInputStream.readInt();
            System.out.println(numero);
            // bool
            boolean valor = dataInputStream.readBoolean();
            System.out.println(valor);
            // char
            char letra = dataInputStream.readChar();
            System.out.println(letra);

        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Problema con el fichero");
            System.out.println(e.getMessage());
        }finally {
            try {
                dataInputStream.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error al cerrar");
            }
        }
    }

    public void escribirObjeto(String path){
        File file = new File(path);
        ObjectOutputStream objectOutputStream = null;

        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(new Producto(1, "Producto1", 97.76, 2));
            objectOutputStream.writeObject(new Tienda("Tienda1", 123, 10));
        } catch (IOException e) {
            System.out.println("Error en el fichero");
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error al cerrar");
            }
        }
    }

    public void lecturaObjeto(String path){
        File file = new File(path);
        ObjectInputStream objectInputStream = null;

        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
            Producto producto = (Producto) objectInputStream.readObject(); // hay que castear el tipo de Clase
            //Se necesita el mismo serialVersionUID para la lectura
            producto.mostrarDatos();

            Tienda tienda = (Tienda) objectInputStream.readObject();
            tienda.mostrarDatos();

        } catch (IOException e) {
            System.out.println("Error en la lectura del fichero");
        } catch (ClassNotFoundException e) { //Significa que no entiende la Clase que tiene que leer con el readObject
            System.out.println("No se encuentra la clase destino");
        } catch (ClassCastException e){
            System.out.println("Error al declarar el tipo de datos");
        }
    }
}
