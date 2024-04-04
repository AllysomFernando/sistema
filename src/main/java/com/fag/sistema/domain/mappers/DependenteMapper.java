package com.fag.sistema.domain.mappers;

import com.fag.sistema.domain.dto.DependenteDTO;
import com.fag.sistema.domain.entities.Dependente;

public class DependenteMapper {
    public static Dependente toBO(DependenteDTO dto){
        return new Dependente(
                dto.getNome(),
                dto.getDataNascimento()
        );
    }

    public static DependenteDTO toDTO(Dependente bo){
        DependenteDTO dto = new DependenteDTO();

        dto.setNome(bo.getNome());
        dto.setDataNascimento(bo.getDataNascimento());

        return dto;
    }
}
