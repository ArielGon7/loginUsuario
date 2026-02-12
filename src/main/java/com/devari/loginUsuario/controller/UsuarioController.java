package com.devari.loginUsuario.controller;

import com.devari.loginUsuario.dto.UsuarioRecord;
import com.devari.loginUsuario.dto.UsuarioRequestDTO;
import com.devari.loginUsuario.dto.UsuarioResponseDTO;
import com.devari.loginUsuario.service.UsuarioService;
import jakarta.validation.Valid;
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
    public ResponseEntity<UsuarioResponseDTO> save(
            @Valid @RequestBody UsuarioRequestDTO request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioService.save(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> update(@Valid @RequestBody UsuarioRequestDTO requestDTO,@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.update(requestDTO, id));
    }
}
