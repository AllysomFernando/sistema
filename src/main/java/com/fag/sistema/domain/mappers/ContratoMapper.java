package com.fag.sistema.domain.mappers;

import com.fag.sistema.domain.dto.ContratoDTO;
import com.fag.sistema.domain.entities.Contrato;

public class ContratoMapper {
    public static Contrato toBO(ContratoDTO dto){
        return new Contrato(
                dto.getDataAdmissao(),
                dto.getCargo(),
                dto.getFuncao(),
                dto.getPisPasep(),
                dto.getHoras(),
                dto.getGrauInsalubridade(),
                dto.getEmpregador(),
                dto.getSalario(),
                dto.getAtivo(),
                dto.getHorarioTrabalho(),
                dto.getTipoContrato(),
                dto.getDescricao()
        );
    }
    public static ContratoDTO toDTO(Contrato bo){
        ContratoDTO dto = new ContratoDTO();

        dto.setDataAdmissao(bo.getDataAdmissao());
        dto.setCargo(bo.getCargo());
        dto.setFuncao(bo.getFuncao());
        dto.setPisPasep(bo.getPisPasep());
        dto.setHoras(bo.getHoras());
        dto.setGrauInsalubridade(bo.getGrauInsalubridade());
        dto.setEmpregador(bo.getEmpregador());
        dto.setSalario(bo.getSalario());
        dto.setAtivo(bo.getAtivo());
        dto.setHorarioTrabalho(bo.getHorarioTrabalho());
        dto.setTipoContrato(bo.getTipoContrato());
        dto.setDescricao(bo.getDescricao());

        return dto;
    }
}
