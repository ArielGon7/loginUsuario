package com.devari.loginUsuario.mapper;

import com.devari.loginUsuario.dto.UsuarioRequestDTO;
import com.devari.loginUsuario.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.web.bind.annotation.RequestBody;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UsuarioUpdate {

    void usuarioUpdate(@RequestBody UsuarioRequestDTO request, @MappingTarget Usuario usuario);

}
