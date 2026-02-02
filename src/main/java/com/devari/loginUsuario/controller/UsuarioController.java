package com.devari.loginUsuario.controller;

import com.devari.loginUsuario.entity.Usuario;
import com.devari.loginUsuario.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> findByAll(){
        return usuarioService.findByAll();
    }

    @PostMapping
    public Usuario save(@RequestBody Usuario usuario){
        return usuarioService.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        usuarioService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Usuario upload(@PathVariable Long id, @RequestBody Usuario usuario){
        return usuarioService.upload(id, usuario);
    }


}
