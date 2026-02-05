package com.devari.loginUsuario.mapper;

import com.devari.loginUsuario.dto.UsuarioRecord;
import com.devari.loginUsuario.dto.UsuarioRequestDTO;
import com.devari.loginUsuario.dto.UsuarioResponseDTO;
import com.devari.loginUsuario.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "id", ignore = true)
    Usuario toUsuarioEntity(UsuarioRequestDTO requestDTO);

    List<UsuarioRecord> toRecord(List<Usuario> usuario);

    UsuarioResponseDTO toResponseDTO(Usuario usuario);

    List<UsuarioResponseDTO> listResponseDTO(List<Usuario> lista);


}
