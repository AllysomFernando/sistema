package com.fag.sistema.domain.enums;

import java.math.BigDecimal;

public enum EnumGrauInsalubridade {
  NULO(0, BigDecimal.ZERO),
  BAIXO(10, new BigDecimal("0.1")),
  MEDIO(20, new BigDecimal("0.2")),
  ALTO(40, new BigDecimal("0.4"));

  private Integer grauInsalubridade;
  private BigDecimal multiplicador;

  EnumGrauInsalubridade(Integer grauInsalubridade, BigDecimal multiplicador) {
    this.grauInsalubridade = grauInsalubridade;
    this.multiplicador = multiplicador;
  }

  public Integer getGrauInsalubridade() {
    return grauInsalubridade;
  }

  public BigDecimal getMultiplicador() {
    return multiplicador;
  }
}
