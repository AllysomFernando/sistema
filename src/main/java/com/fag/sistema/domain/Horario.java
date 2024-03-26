package com.fag.sistema.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Horario {
    private float hora_trabalhadas;
    private float hora_falta;
    private Boolean justificativa;
    private Float horas_extras;
    private Float horas_extras_final_de_semana;

    public Float calcularHorario(Float hora_trabalhadas, Float hora_falta, Boolean justificativa){
        Float horas = 1.0F;
        return horas;
    }
}
