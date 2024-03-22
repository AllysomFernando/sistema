package com.fag.sistema.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Horario {
    public float hora_trabalhadas;
    public float hora_falta;
    public Boolean justificativa;


    private Float calcularHorario(Float hora_trabalhadas, Float hora_falta, Boolean justificativa){
        Float horas = 1.0F;

        return horas;
    }
}
