package com.fag.sistema.domain.mappers;

import com.fag.sistema.domain.dto.HoleriteDTO;
import com.fag.sistema.domain.entities.Holerite;

public class HoleriteMapper {
    public static Holerite toBO(HoleriteDTO dto) {
        Holerite holerite = new Holerite();
        holerite.setEmpregador(dto.getEmpregador());
        holerite.setEmpregado(dto.getEmpregado());
        holerite.setProventos(ProventosMapper.toBO(dto.getProventos()));
        return holerite;
    }

    public static HoleriteDTO toDTO(Holerite entity) {
        HoleriteDTO dto = new HoleriteDTO();
        dto.setEmpregador(entity.getEmpregador());
        dto.setEmpregado(entity.getEmpregado());
        dto.setProventos(ProventosMapper.toDTO(entity.getProventos()));
        return dto;
    }
}
