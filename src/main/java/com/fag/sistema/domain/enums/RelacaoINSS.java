package com.fag.sistema.domain.enums;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public enum RelacaoINSS {
  OITO(new BigDecimal("1751.81"), BigDecimal.ZERO, new BigDecimal("0.075")) {
    @Override
    public boolean compare(BigDecimal value) {
      return value.compareTo(this.getSalarioInicial()) <= 0;
    }
  },
  NOVE(new BigDecimal("1751.82"), new BigDecimal("2919.72"), new BigDecimal("0.09")) {
    @Override
    public boolean compare(BigDecimal value) {
      return value.compareTo(this.getSalarioInicial()) >= 0 && value.compareTo(this.getSalarioFinal()) <= 0;
    }
  },
  ONZE(new BigDecimal("2919.73"), new BigDecimal("5839.45"), new BigDecimal("0.11")) {
    @Override
    public boolean compare(BigDecimal value) {
      return value.compareTo(this.getSalarioInicial()) >= 0 && value.compareTo(this.getSalarioFinal()) <= 0;
    }
  };

  private BigDecimal salarioInicial;
  private BigDecimal salarioFinal;
  private BigDecimal referencia;

  RelacaoINSS(BigDecimal salarioInicial, BigDecimal salarioFinal, BigDecimal referencia) {
    this.salarioInicial = salarioInicial;
    this.salarioFinal = salarioFinal;
    this.referencia = referencia;
  }

  public abstract boolean compare(BigDecimal value);
}
