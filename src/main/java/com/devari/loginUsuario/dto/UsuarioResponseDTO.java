package com.devari.loginUsuario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UsuarioResponseDTO {
    @JsonProperty(required = true)
    private String name;
    @JsonProperty(required = true)
    private String email;

}
