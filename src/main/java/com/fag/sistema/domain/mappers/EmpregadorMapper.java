package com.fag.sistema.domain.mappers;

import com.fag.sistema.domain.dto.EmpregadorDTO;
import com.fag.sistema.domain.entities.empresa.Empregador;

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
                dto.getEndereco(),
                dto.getEmpregados());
    }

    public static EmpregadorDTO toDTO(Empregador bo) {
        EmpregadorDTO dto = new EmpregadorDTO();

        dto.setId(bo.getCnpj());
        dto.setCNPJ(bo.getCnpj());
        dto.setRazaoSocial(bo.getRazaoSocial());
        dto.setNomeFantasia(bo.getNomeFantasia());
        dto.setNome(bo.getNomeFantasia());
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
