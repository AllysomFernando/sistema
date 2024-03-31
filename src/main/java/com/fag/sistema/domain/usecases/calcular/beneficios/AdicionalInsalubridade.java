package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;

import com.fag.sistema.domain.entities.Empregado;

public class AdicionalInsalubridade implements IBeneficioUseCase {

  @Override
  public BigDecimal calculate(Empregado empregado) {
    Integer grauInsalubridade = empregado.getContrato().getGrauInsalubridade();
    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();

    if (grauInsalubridade == 10) {
      return salarioBruto.multiply(new BigDecimal("0.1"));
    }

    if (grauInsalubridade == 20) {
      return salarioBruto.multiply(new BigDecimal("0.2"));
    }

    if (grauInsalubridade == 40) {
      return salarioBruto.multiply(new BigDecimal("0.4"));
    }
    
    return salarioBruto.multiply(new BigDecimal("0.0"));
  }

}
