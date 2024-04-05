package com.fag.sistema.domain.mappers;

import com.fag.sistema.domain.dto.HorarioDTO;
import com.fag.sistema.domain.entities.Horario;

public class HorarioMapper {
    public static Horario toBO(HorarioDTO dto){
        return new Horario(
                dto.getHoraTrabalhada(),
                dto.getHoraFalta(),
                dto.getJustificativa(),
                dto.getHoraExtra(),
                dto.getHoraExtraFDS(),
                dto.getHorasNoturnas()
        );
    }

    public static HorarioDTO toDTO(Horario bo){
        HorarioDTO dto = new HorarioDTO();
        dto.setHoraTrabalhada(bo.getHoraTrabalhada());
        dto.setHoraFalta(bo.getHoraFalta());
        dto.setJustificativa(bo.getJustificativa());
        dto.setHoraExtra(bo.getHoraExtra());
        dto.setHoraExtraFDS(bo.getHoraExtraFDS());
        dto.setHorasNoturnas(bo.getHorasNoturnas());
        return dto;
    }
}
