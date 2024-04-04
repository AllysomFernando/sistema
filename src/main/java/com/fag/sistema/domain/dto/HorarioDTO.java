package com.fag.sistema.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HorarioDTO {
    private float horaTrabalhada;
    private float horaFalta;
    private Boolean justificativa;
    private float horaExtra;
    private float horaExtraFDS;
}
