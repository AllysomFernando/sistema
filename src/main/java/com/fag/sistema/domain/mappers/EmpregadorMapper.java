package com.fag.sistema.domain.mappers;

import com.fag.sistema.domain.dto.EmpregadoDTO;
import com.fag.sistema.domain.dto.EmpregadorDTO;
import com.fag.sistema.domain.entities.Empregador;

public class EmpregadorMapper {
    public static Empregador toBO(EmpregadorDTO dto) {
        return new Empregador(
                dto.getCNPJ(),
                dto.getRazaoSocial(),
                dto.getNomeFantasia(),
                dto.getClassificacaoTributaria(),
                dto.getPorteEmpresa(),
                dto.getNaturezaJuridica(),
                dto.getRamoAtividade(),
                dto.getInscricao(),
                dto.getContato(),
                dto.getEndereco()
        );
    }
    public static EmpregadorDTO toDTO(Empregador bo){
        EmpregadorDTO dto = new EmpregadorDTO();

        dto.setCNPJ(bo.getCNPJ());
        dto.setRazaoSocial(bo.getRazaoSocial());
        dto.setNomeFantasia(bo.getNomeFantasia());
        dto.setClassificacaoTributaria(bo.getClassificacaoTributaria());
        dto.setPorteEmpresa(bo.getPorteEmpresa());
        dto.setNaturezaJuridica(bo.getNaturezaJuridica());
        dto.setRamoAtividade(bo.getRamoAtividade());
        dto.setInscricao(bo.getInscricao());
        dto.setContato(bo.getContato());
        dto.setEndereco(bo.getEndereco());

        return dto;
    }
}
