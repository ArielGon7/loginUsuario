package com.devari.loginUsuario.service;

import com.devari.loginUsuario.dto.UsuarioRecord;
import com.devari.loginUsuario.dto.UsuarioRequestDTO;
import com.devari.loginUsuario.dto.UsuarioResponseDTO;
import com.devari.loginUsuario.entity.Usuario;
import com.devari.loginUsuario.mapper.UsuarioMapper;
import com.devari.loginUsuario.mapper.UsuarioUpdate;
import com.devari.loginUsuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper mapper;
    private final UsuarioUpdate usuarioUpdate;

    public List<UsuarioRecord> findAll(){
        return mapper.toRecord(usuarioRepository.findAll());
    }

    public UsuarioResponseDTO findByEmail(String email){
        return mapper.toResponseDTO(usuarioRepository.findByEmail(email));
    }

    public UsuarioResponseDTO save(UsuarioRequestDTO request) {
        return mapper.toResponseDTO(usuarioRepository.save(mapper.toUsuarioEntity(request)));
    }

    public void deleteById(Long id) {
        if (!usuarioRepository.existsById(id)){
            throw new IllegalArgumentException("usuario id not exist");
        }
        usuarioRepository.deleteById(id);
    }

    public UsuarioResponseDTO update(UsuarioRequestDTO request, Long id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario not found"));
        usuarioUpdate.usuarioUpdate(request, usuario);
        return mapper.toResponseDTO(usuarioRepository.save(usuario));
    }

//    public void verifyEmptyOrNull(UsuarioRequestDTO usuario){
//        if (usuario.getName() == null || usuario.getName().isBlank()){
//            throw new IllegalArgumentException("name is empty or null");
//        }
//    }
}
