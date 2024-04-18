package com.fag.sistema.domain.entities.empregado;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
    this.bruto = bruto.setScale(2, RoundingMode.HALF_DOWN);
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
    // this.baseCalculoIRRF = this.baseCalculoIRRF.add(value);
  }

  public void subtrairBasesDeCalculo(BigDecimal value) {

    if (this.baseCalculoFGTS.compareTo(BigDecimal.ZERO) > 0) {
      this.baseCalculoFGTS = this.baseCalculoFGTS.subtract(value);
    }

    if (this.baseCalculoIRRF.compareTo(BigDecimal.ZERO) > 0) {
      this.baseCalculoIRRF = this.baseCalculoIRRF.subtract(value);
    }

    if (this.baseCalculoInss.compareTo(BigDecimal.ZERO) > 0) {
      this.baseCalculoInss = this.baseCalculoInss.subtract(value);
    }

  }

  public void setBaseCalculoFGTS(BigDecimal value) {
    this.baseCalculoFGTS = baseCalculoFGTS.add(value);
  }

  public void setBaseCalculoIrrf(BigDecimal value) {
    this.baseCalculoIRRF = baseCalculoIRRF.add(value);
  }

  public void setBaseCalculoInss(BigDecimal value) {
    this.baseCalculoInss = baseCalculoInss.add(value);
  }

  public void subtrairBaseCalculoIrrf(BigDecimal value) {
    this.baseCalculoIRRF = baseCalculoIRRF.subtract(value);
  }
}
