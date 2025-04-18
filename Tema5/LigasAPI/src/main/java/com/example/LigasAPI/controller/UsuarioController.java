package com.example.LigasAPI.controller;

// Anotaciones de JPA para el mapeo con la BBDD

import com.example.LigasAPI.model.Usuario;
import com.example.LigasAPI.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/error")
    public String getError(){
        return "Error en la conexión";
    }


    @PostMapping("/add")
    public ResponseEntity<Usuario> addUser(@RequestBody Usuario usuario){
        return new ResponseEntity<>(usuarioService.insertarUsuario(usuario), HttpStatus.OK);
    }

    @GetMapping("/getMail")
    public ResponseEntity<List<Usuario>> getUserMail(@RequestParam String correo){
        return new ResponseEntity<>(usuarioService.getUsuarioCorreo(correo), HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity<Usuario> getUserLogin(@RequestParam String correo, @RequestParam String pass){

        Usuario usuario = usuarioService.getLogin(correo, pass);

        if (usuario!=null){
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
