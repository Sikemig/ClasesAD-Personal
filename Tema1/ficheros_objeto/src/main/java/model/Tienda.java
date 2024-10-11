package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Tienda implements Serializable {

    private static final Long serialVersionUid = 3456L;
    private String nombre;
    private int id;
    private int empleados;

    public void mostrarDatos() {
        System.out.println("serialVersionUid = " + serialVersionUid);
        System.out.println("nombre = " + nombre);
        System.out.println("id = " + id);
        System.out.println("empleados = " + empleados);
    }
}
