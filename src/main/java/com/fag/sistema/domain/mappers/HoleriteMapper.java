package com.fag.sistema.domain.mappers;

import com.fag.sistema.domain.dto.HoleriteDTO;
import com.fag.sistema.domain.entities.Holerite;

public class HoleriteMapper {
    public static Holerite toBO(HoleriteDTO dto) {
        Holerite holerite = new Holerite();

        holerite.setBaseCalculoFgts(dto.getBaseCalculoFgts());
        holerite.setBaseCalculoIrrf(dto.getBaseCalculoIrrf());
        holerite.setSalarioContribuicaoInss(dto.getSalarioContribuicaoInss());
        holerite.setEmpregador(dto.getEmpregador());
        holerite.setEmpregado(dto.getEmpregado());
        holerite.setProventos(ProventosMapper.toBO(dto.getProventos()));
        holerite.setFgtsMensal(dto.getFgtsMensal());
        return holerite;
    }

    public static HoleriteDTO toDTO(Holerite entity) {
        HoleriteDTO dto = new HoleriteDTO();

        dto.setBaseCalculoFgts(entity.getBaseCalculoFgts());
        dto.setBaseCalculoIrrf(entity.getBaseCalculoIrrf());
        dto.setSalarioContribuicaoInss(entity.getSalarioContribuicaoInss());
        dto.setEmpregador(entity.getEmpregador());
        dto.setEmpregado(entity.getEmpregado());
        dto.setProventos(ProventosMapper.toDTO(entity.getProventos()));
        dto.setFgtsMensal(entity.getFgtsMensal());
        return dto;
    }
}
