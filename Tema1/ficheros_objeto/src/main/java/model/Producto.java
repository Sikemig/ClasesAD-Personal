package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Producto implements Serializable {
    // variables - private
    private int id;
    private String title;
    private double price;
    private int stock;

    // obligatorio constructores getters y setters, con libreria lombok se hace mas facil
    // arriba se pone el @Setter, @Getter, @NoArgsConstructor y @AllArgsConstructor

    //constructores --> de manera predeteminada hay 1, el vacío
    // el constructor vacío desaparece en cuanto ponemos otro constructor, por lo que hay que ponerlo manualmente

    //Si queremos un constructor con menos argumentos SI TENEMOS que hacerlo manualmente (clic derecho)

    public Producto(String title, double price, int stock) {
        this.title = title;
        this.price = price;
        this.stock = stock;
    }
}
