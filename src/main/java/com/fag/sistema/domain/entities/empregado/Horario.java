package com.fag.sistema.domain.entities.empregado;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Horario {
    private Boolean justificativa;
    private float horasExtras;
    private float horasExtrasEmFinsDeSemana;
    private float horasAdicionalNoturno;
    private Integer horasEmDeficit;
}
