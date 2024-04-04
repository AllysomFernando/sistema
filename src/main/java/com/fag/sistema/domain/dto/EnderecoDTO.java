package com.fag.sistema.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO {
    private String rua;
    private String numero;
    private String bairro;
    private String CEP;
    private String municipio;
    private String estado;
}
