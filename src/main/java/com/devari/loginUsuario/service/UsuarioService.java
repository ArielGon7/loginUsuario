package com.devari.loginUsuario.service;

import com.devari.loginUsuario.entity.Usuario;
import com.devari.loginUsuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public List<Usuario> findByAll() {
        return usuarioRepository.findAll();
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario upload(Long id, Usuario usuario){
        Usuario usuarioDb = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario not found"));
        usuarioDb.setName(usuario.getName());
        return usuarioRepository.save(usuarioDb);
    }
}
