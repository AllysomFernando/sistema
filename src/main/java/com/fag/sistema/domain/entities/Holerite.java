package com.fag.sistema.domain.entities;

import java.math.BigDecimal;

import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empresa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Holerite {
    private Empresa empregador;
    private Empregado empregado;
    private Proventos proventos;
    private BigDecimal baseCalculoIrrf;
    private BigDecimal baseCalculoFgts;
    private BigDecimal salarioContribuicaoInss;
    private BigDecimal FgtsMensal;
}
