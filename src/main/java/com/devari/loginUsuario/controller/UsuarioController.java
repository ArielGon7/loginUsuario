package com.devari.loginUsuario.controller;

import com.devari.loginUsuario.dto.UsuarioRecord;
import com.devari.loginUsuario.dto.UsuarioRequestDTO;
import com.devari.loginUsuario.dto.UsuarioResponseDTO;
import com.devari.loginUsuario.entity.Usuario;
import com.devari.loginUsuario.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioRecord>> findByAll(){
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping("/{email}")
    public ResponseEntity<UsuarioResponseDTO> findByEmail(@PathVariable String email){
        return ResponseEntity.ok(usuarioService.findByEmail(email));
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> save(@RequestBody UsuarioRequestDTO usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario){
//        return ResponseEntity.ok(usuarioService.update(id, usuario));
//    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> update(@RequestBody UsuarioRequestDTO requestDTO,@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.update(requestDTO, id));
    }


}
