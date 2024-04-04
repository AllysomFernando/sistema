package com.fag.sistema.domain.mappers;

import com.fag.sistema.domain.dto.SalarioDTO;
import com.fag.sistema.domain.entities.Salario;

public class SalarioMapper {

    public static Salario toBO(SalarioDTO dto){
        return new Salario(
                dto.getBruto(),
                dto.getLiquido()
        );
    }
    public static SalarioDTO toDTO(Salario bo){
        SalarioDTO dto = new SalarioDTO();

        dto.setBruto(bo.getBruto());
        dto.setLiquido(bo.getLiquido());

        return dto;
    }
}
