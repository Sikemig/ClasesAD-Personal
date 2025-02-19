package com.example.LigasAPI.controller;

// Se utiliza como punto de entrada de las peticiones REST

import com.example.LigasAPI.model.Liga;
import com.example.LigasAPI.service.LigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("ligas")
public class LigaController {

    @Autowired
    private LigaService ligaService;

    // Aqui van todos los metodos que quiero que se puedan ejecutar desde la url
    @GetMapping("error")
    public String getError(){
        return "Error en la app";
    }

    @PostMapping("add")
    public String addLiga(){
        ligaService.agregarLiga(new Liga("LigaNueva"));
        return "Liga agregada correctamente";
    }
}
