package com.fag.sistema.domain.dto;

import java.math.BigDecimal;

import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empresa;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HoleriteDTO {
   private Empresa empregador;
   private Empregado empregado;
   private ProventosDTO proventos;
   private BigDecimal baseCalculoInss;
   private BigDecimal baseCalculoFgts;
   private BigDecimal baseCalculoIrrf;
   private BigDecimal fgtsMensal;
}
