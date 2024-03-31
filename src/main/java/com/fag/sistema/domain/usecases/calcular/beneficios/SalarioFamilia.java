package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;

import com.fag.sistema.domain.entities.Empregado;

public class SalarioFamilia implements IBeneficioUseCase  {

  @Override
  public BigDecimal calculate(Empregado empregado) {
    BigDecimal salarioMinimo = new BigDecimal("1100.00");
      return salarioMinimo.multiply(new BigDecimal("0.05"));
  }
  
}
