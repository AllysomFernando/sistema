package com.fag.sistema.domain.mappers;

import com.fag.sistema.domain.dto.EmpregadoDTO;
import com.fag.sistema.domain.entities.empregado.Empregado;

public class EmpregadoMapper {
    public static Empregado toBO(EmpregadoDTO dto) {
        return new Empregado(
                dto.getNome(),
                dto.getGenero(),
                dto.getDoencas(),
                dto.getCPF(),
                dto.getDataNascimento(),
                dto.getDependentes(),
                dto.getHorario(),
                dto.getContrato(),
                dto.getEndereco());
    }

    public static EmpregadoDTO toDTO(Empregado bo) {
        EmpregadoDTO dto = new EmpregadoDTO();
        dto.setNome(bo.getNome());
        dto.setGenero(bo.getGenero());
        dto.setDoencas(bo.getDoencas());
        dto.setCPF(bo.getCpf());
        dto.setDataNascimento(bo.getDataNascimento());
        dto.setDependentes(bo.getDependentes());
        dto.setHorario(bo.getHorario());
        dto.setHorario(bo.getHorario());
        dto.setContrato(bo.getContrato());
        dto.setEndereco(bo.getEndereco());

        return dto;
    }
}
