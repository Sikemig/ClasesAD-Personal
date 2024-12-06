package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    private String nombre;
    private String apellido;
    private String correo;
    private String pass;

    public void mostrarDatos(){
        System.out.println("Nombre: "+ nombre);
        System.out.println("Apellido: "+ apellido);
        System.out.println("Correo: "+ correo);
        System.out.println("Pass: "+ pass);
    }

    // AQUI NO SE HACEN TRANSACION CON DB


    public Usuario(String nombre, String correo, String pass) {
        this.nombre = nombre;
        this.correo = correo;
        this.pass = pass;
    }
}
