package com.fag.sistema.domain.entities.empregado;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Salario {
  private BigDecimal bruto;
  private BigDecimal liquido;
  private BigDecimal base;
  private BigDecimal baseCalculoIRRF;
  private BigDecimal baseCalculoFGTS;
  private BigDecimal baseCalculoInss;
  private BigDecimal FgtsMensal;

  public Salario(BigDecimal bruto) {
    this.bruto = bruto;
    this.liquido = BigDecimal.ZERO;
    this.base = BigDecimal.ZERO;
    this.baseCalculoIRRF = this.bruto;
    this.baseCalculoFGTS = this.bruto;
    this.baseCalculoInss = this.bruto;
    this.FgtsMensal = BigDecimal.ZERO;
  }

  public Salario() {
    this.bruto = BigDecimal.ZERO;
    this.liquido = BigDecimal.ZERO;
    this.base = BigDecimal.ZERO;
    this.baseCalculoIRRF = this.bruto;
    this.baseCalculoFGTS = this.bruto;
    this.baseCalculoInss = this.bruto;
    this.FgtsMensal = BigDecimal.ZERO;
  }

  public void somarBasesDeCalculo(BigDecimal value) {
    this.baseCalculoFGTS = this.baseCalculoFGTS.add(value);
    this.baseCalculoInss = this.baseCalculoInss.add(value);
    this.baseCalculoIRRF = this.baseCalculoIRRF.add(value);
  }

  public void subtrairBasesDeCalculo(BigDecimal value) {
    this.baseCalculoFGTS = this.baseCalculoFGTS.subtract(value);
    this.baseCalculoInss = this.baseCalculoInss.subtract(value);
    this.baseCalculoIRRF = this.baseCalculoIRRF.subtract(value);
  }
}
