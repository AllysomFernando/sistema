package com.fag.sistema.domain.enums;

public enum EnumGrauInsalubridade {
  NULO(0),
  BAIXO(10),
  MEDIO(20),
  ALTO(40);

  private Integer grauInsalubridade;

  EnumGrauInsalubridade(Integer grauInsalubridade) {
    this.grauInsalubridade = grauInsalubridade;
  }

  public Integer getGrauInsalubridade() {
    return grauInsalubridade;
  }
}
