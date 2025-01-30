package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "equipos")
public class Equipo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nombre;

    @Column
    private String ciudad;

    // Unidireccional, para la bidireccionalidad hay que hacerlo en entrenador tambien
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_entrenador")
    private Entrenador entrenador;


    @OneToMany(mappedBy = "equipo", fetch = FetchType.EAGER) // sin el fetch, no va a responder con la lista cuando se obtengaPlantilla
    private List<Jugador> jugadores;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_liga")
    private Liga liga;


    // Entidad dominante entre equipos-competiciones
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "inscripciones",
            joinColumns = @JoinColumn(name = "id_equipo"),
            inverseJoinColumns = @JoinColumn(name = "id_competicion"))
    private List<Competicion> competiciones;


    public Equipo(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
    }
}
