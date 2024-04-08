package com.fag.sistema.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Horario {
    private float horaTrabalhada;
    private float horaFalta;
    private Boolean justificativa;
    private float horaExtra;
    private float horaExtraFDS;
    private float horasNoturnas;
}
