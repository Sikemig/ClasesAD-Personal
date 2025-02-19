package com.example.LigasAPI.repository;

import com.example.LigasAPI.model.Liga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Se crean tantos metodos "adicionales" como necesitemos que van contra BBDD
// los metodos por "defecto" me los da el JpaRepository
    // persist
    // save
    // merge
    // list
public interface LigaRepository extends JpaRepository<Liga, Integer> {

    // metodo adicional, ejemplo
    Liga findByNombre(String string);
}
