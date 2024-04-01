package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;

import com.fag.sistema.domain.entities.Empregado;
import com.fag.sistema.domain.enums.EnumGrauInsalubridade;

public class AdicionalInsalubridade implements IBeneficioUseCase {

  @Override
  public BigDecimal calculate(Empregado empregado) {
    EnumGrauInsalubridade grauInsalubridade = empregado.getContrato().getGrauInsalubridade();
    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();

    if (grauInsalubridade == EnumGrauInsalubridade.BAIXO) {
      return salarioBruto.multiply(new BigDecimal("0.1"));
    }

    if (grauInsalubridade == EnumGrauInsalubridade.MEDIO) {
      return salarioBruto.multiply(new BigDecimal("0.2"));
    }

    if (grauInsalubridade == EnumGrauInsalubridade.ALTO) {
      return salarioBruto.multiply(new BigDecimal("0.4"));
    }
    
    return salarioBruto.multiply(new BigDecimal("0.0"));
  }

}
