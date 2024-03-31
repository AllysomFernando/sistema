package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;

import com.fag.sistema.domain.entities.Empregado;

public class SalarioMaternidade implements IBeneficioUseCase{

  @Override
  public BigDecimal calculate(Empregado empregado) {
    BigDecimal beneficiolMensal = empregado.getContrato().getSalario().getBruto().multiply(new BigDecimal("0.05"));
      return beneficiolMensal.multiply(new BigDecimal("6"));
  }
  
}
