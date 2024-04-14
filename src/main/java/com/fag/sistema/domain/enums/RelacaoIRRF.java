package com.fag.sistema.domain.enums;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public enum RelacaoIRRF {
  SETE_E_MEIO(new BigDecimal("1903.99"), new BigDecimal("2826.65"), new BigDecimal("0.075")) {
    @Override
    public boolean compare(BigDecimal value) {
      return value.compareTo(this.getSalarioInicial()) >= 0 && value.compareTo(this.getSalarioFinal()) <= 0;
    }
  },
  QUINZE(new BigDecimal("2826.66"), new BigDecimal("3751.05"), new BigDecimal("0.15")) {
    @Override
    public boolean compare(BigDecimal value) {
      return value.compareTo(this.getSalarioInicial()) >= 0 && value.compareTo(this.getSalarioFinal()) <= 0;
    }
  },
  VINTE_DOIS_E_SETE(new BigDecimal("3751.06"), new BigDecimal("4664.68"), new BigDecimal("0.225")) {
    @Override
    public boolean compare(BigDecimal value) {
      return value.compareTo(this.getSalarioInicial()) >= 0 && value.compareTo(this.getSalarioFinal()) <= 0;
    }
  },
  VINTE_SETE_E_MEIO(new BigDecimal("4664.68"), new BigDecimal("5839.45"), new BigDecimal("0.275")) {
    @Override
    public boolean compare(BigDecimal value) {
      return value.compareTo(this.getSalarioInicial()) >= 0;
    }
  };

  private BigDecimal salarioInicial;
  private BigDecimal salarioFinal;
  private BigDecimal referencia;

  RelacaoIRRF(BigDecimal salarioInicial, BigDecimal salarioFinal, BigDecimal referencia) {
    this.salarioInicial = salarioInicial;
    this.salarioFinal = salarioFinal;
    this.referencia = referencia;
  }

  public abstract boolean compare(BigDecimal value);
}
