package com.fag.sistema.domain.mappers;

import com.fag.sistema.domain.dto.InscricaoDTO;
import com.fag.sistema.domain.entities.Inscricao;

public class InscricaoMapper {
    public static Inscricao toBO(InscricaoDTO dto){
        return new Inscricao(
                dto.getTipoInscricao(),
                dto.getNumero(),
                dto.getInscricaoEstadual(),
                dto.getInscricaoMunicipal()
        );
    }
    public static InscricaoDTO toDTO(Inscricao bo){
        InscricaoDTO dto = new InscricaoDTO();
        dto.setTipoInscricao(bo.getTipoInscricao());
        dto.setNumero(bo.getNumero());
        dto.setInscricaoEstadual(bo.getInscricaoEstadual());
        dto.setInscricaoMunicipal(bo.getInscricaoMunicipal());

        return dto;
    }
}
