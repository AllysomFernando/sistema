package com.fag.sistema.domain.mappers;

import com.fag.sistema.domain.dto.DoencaDTO;
import com.fag.sistema.domain.entities.Doenca;

public class DoencaMapper {
    public static Doenca toBO(DoencaDTO dto) {
        return new Doenca(
                dto.getDescricao()
        );
    }
    public static DoencaDTO toDTO(Doenca bo) {
        DoencaDTO dto = new DoencaDTO();
        dto.setDescricao(bo.getDescricao());
        return dto;
    }
}
