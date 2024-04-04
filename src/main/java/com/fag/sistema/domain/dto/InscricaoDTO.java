package com.fag.sistema.domain.dto;

import com.fag.sistema.domain.enums.EnumTipoInscricao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InscricaoDTO {
    private EnumTipoInscricao tipoInscricao;
    private String numero;
    private String inscricaoEstadual;
    private String inscricaoMunicipal;
}
