package com.fag.sistema.domain.mappers;

import com.fag.sistema.domain.dto.EmpregadorDTO;
import com.fag.sistema.domain.entities.empresa.Empresa;

public class EmpresaMapper {
    public static Empresa toBO(EmpregadorDTO dto) {
        return new Empresa(
                dto.getCnpj(),
                dto.getRazaoSocial(),
                dto.getNomeFantasia(),
                dto.getRamoAtividade(),
                dto.getInscricao(),
                dto.getCargaHorariaDiaria(),
                dto.getDiasATrabalhar(),
                dto.getEmpregados(),
                dto.getFuncionariasComSalarioMaternidade(),
                dto.getFuncionariosAgrupados());
    }

    public static EmpregadorDTO toDTO(Empresa bo) {
        EmpregadorDTO dto = new EmpregadorDTO();

        dto.setCnpj(bo.getCnpj());
        dto.setRazaoSocial(bo.getRazaoSocial());
        dto.setNomeFantasia(bo.getNomeFantasia());
        dto.setRamoAtividade(bo.getRamoAtividade());
        dto.setInscricao(bo.getInscricao());
        dto.setEmpregados(bo.getEmpregados());
        dto.setDiasATrabalhar(bo.getDiasATrabalhar());
        dto.setCargaHorariaDiaria(bo.getCargaHorariaDiaria());
        dto.setFuncionariasComSalarioMaternidade(bo.getFuncionariasComSalarioMaternidade());
        dto.setFuncionariosAgrupados(bo.getFuncionariosAgrupados());

        return dto;
    }
}
