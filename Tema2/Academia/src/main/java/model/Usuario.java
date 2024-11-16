package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable {

    @BsonProperty("name")
    private String nombre;

    @BsonProperty("surname")
    private String apellido;

    @BsonProperty("age")
    private int edad;

    @BsonProperty("mail")
    private String correo;

    public void mostrarDatos(){
        System.out.println("nombre= " + nombre);
        System.out.println("apellido= " + apellido);
        System.out.println("edad= " + edad);
        System.out.println("correo= " + correo);
    }
}
