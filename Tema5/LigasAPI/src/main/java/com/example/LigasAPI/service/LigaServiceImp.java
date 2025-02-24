package com.example.LigasAPI.service;

import com.example.LigasAPI.model.Liga;
import com.example.LigasAPI.repository.LigaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigaServiceImp implements LigaService{

    @Autowired //el autowired te da los metodos de JPAREPOSITORY
    private LigaRepository ligaRepository;


    public Liga agregarLiga(Liga liga) {
        // queremos que este metodo pueda agregar la liga, pero si no existe previamente con ese nombre
        // necesitamos el repository para poder ejecutar los metodos contra bbdd

        //if(ligaRepository.findByNombre("Calcio") == null){
            return ligaRepository.save(liga);
        //}else {
         //   return null;
        //}
    }


    public List<Liga> getAllLigas() {
        return ligaRepository.findAll();
    }
}
