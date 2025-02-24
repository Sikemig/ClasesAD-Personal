package com.example.LigasAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter

@Entity
@Table(name="usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nombre;

    @Column
    private String correo;

    @Column
    private String pass;

    public Usuario(int id, String nombre, String correo, String pass) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.pass = pass;
    }

    public Usuario() {
    }

    public Usuario(String nombre, String correo, String pass) {
        this.nombre = nombre;
        this.correo = correo;
        this.pass = pass;
    }
}
