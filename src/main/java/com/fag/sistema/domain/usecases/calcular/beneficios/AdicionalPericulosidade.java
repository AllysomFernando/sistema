package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;

import com.fag.sistema.domain.entities.Empregado;

public class AdicionalPericulosidade implements IBeneficioUseCase {

  @Override
  public BigDecimal calculate(Empregado empregado) {
    Integer grauInsalubridade = empregado.getContrato().getGrauInsalubridade();

    if (grauInsalubridade > 0) {
      return BigDecimal.ZERO;
    }

    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();
    return salarioBruto.multiply(new BigDecimal("0.3"));
  }
  
}
