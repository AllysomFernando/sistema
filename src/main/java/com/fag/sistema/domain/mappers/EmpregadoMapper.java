package com.fag.sistema.domain.mappers;

import com.fag.sistema.domain.dto.EmpregadoDTO;
import com.fag.sistema.domain.entities.empregado.Empregado;

public class EmpregadoMapper {
    public static Empregado toBO(EmpregadoDTO dto) {
        return new Empregado(
                dto.getNome(),
                dto.getGenero(),
                dto.getDoencas(),
                dto.getCpf(),
                dto.getDataNascimento(),
                dto.getDependentes(),
                dto.getHorario(),
                dto.getContrato(),
                dto.getTotalDeVendasNoMes(),
                dto.getDiasEmViagem());
    }

    public static EmpregadoDTO toDTO(Empregado bo) {
        EmpregadoDTO dto = new EmpregadoDTO();
        dto.setNome(bo.getNome());
        dto.setGenero(bo.getGenero());
        dto.setDoencas(bo.getDoencas());
        dto.setCpf(bo.getCpf());
        dto.setDataNascimento(bo.getDataNascimento());
        dto.setDependentes(bo.getDependentes());
        dto.setHorario(bo.getHorario());
        dto.setHorario(bo.getHorario());
        dto.setContrato(bo.getContrato());
        dto.setTotalDeVendasNoMes(bo.getTotalDeVendasNoMes());
        dto.setDiasEmViagem(bo.getDiasEmViagem());

        return dto;
    }
}
