package com.fag.sistema.domain.entities;

import com.fag.sistema.domain.usecases.calcular.beneficios.*;
import com.fag.sistema.domain.usecases.calcular.descontos.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Proventos {
    private Integer totalBeneficios;
    private Integer totalDescontos;
}
