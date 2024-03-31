package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;

import com.fag.sistema.domain.entities.Empregado;

public class DiariasParaViagem implements IBeneficioUseCase {

  @Override
  public BigDecimal calculate(Empregado empregado) {
    return new BigDecimal("1000.000");
  }
  
}
