package org.example.gestorligas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table (name ="jugadores")
public class Jugador implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nombre;

    @Column
    private String nacionalidad;

    @Column(name = "valor_mercado")
    private String valorMercado;

    @Column
    private int goles;



    public Jugador(String nombre, String nacionalidad, String valorMercado, int goles) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.valorMercado = valorMercado;
        this.goles = goles;
    }
}
