package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@NamedQuery(name="Trabajador.findAll", query="From Trabajador")
@NamedQuery(name="Trabajador.findAllByLocalidad", query="From Trabajador t WHERE t.direccion.localidad=:localidad")
@NamedQuery(name="Trabajador.findAllByProvincia", query="From Trabajador t WHERE t.direccion.provincia=:provincia")
@NamedQuery(name= "Trabajador.updateName", query ="UPDATE Trabajador SET nombre=:nombre WHERE telefono=:telefono")


@Entity
@Table(name="empleados")
public class Trabajador implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column // si se llama distinto ponemos el (name="name")
    private String nombre;

    @Column
    private String apellido;

    @Embedded
    private Direccion direccion;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name ="localidad", column = @Column(name="localidad_2")),
            @AttributeOverride(name ="provincia", column = @Column(name="provincia_2"))
    })
    private Direccion direccion2;

    @Column
    private int telefono;


    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="id_habitacion")
    private Habitacion habitacion;


    public Trabajador(int id) {
        this.id = id;
    }


    public Trabajador(String nombre, String apellido, Direccion direccion, Direccion direccion2, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.direccion2 = direccion2;
        this.telefono = telefono;
    }

    public Trabajador(String nombre, String apellido, Direccion direccion, Direccion direccion2, int telefono, Habitacion habitacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.direccion2 = direccion2;
        this.telefono = telefono;
        this.habitacion = habitacion;
    }


    @Override
    public String toString() {
        return "Trabajador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion=" + direccion +
                ", direccion2=" + direccion2 +
                ", telefono=" + telefono +
                '}';
    }
}