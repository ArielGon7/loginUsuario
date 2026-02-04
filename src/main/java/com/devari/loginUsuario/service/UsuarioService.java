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

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario save(Usuario usuario) {
        verifyEmptyOrNull(usuario);
        return usuarioRepository.save(usuario);
    }

    public void deleteById(Long id) {
        if (!usuarioRepository.existsById(id)){
            throw new IllegalArgumentException("usuario id not exist");
        }
        usuarioRepository.deleteById(id);
    }

    public Usuario upload(Long id, Usuario usuario){
        verifyEmptyOrNull(usuario);
        Usuario usuarioDb = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario not found"));
        usuarioDb.setName(usuario.getName());
        return usuarioRepository.save(usuarioDb);
    }

    public void verifyEmptyOrNull(Usuario usuario){
        if (usuario.getName() == null || usuario.getName().isBlank()){
            throw new IllegalArgumentException("name is empty or null");
        }
    }
}
