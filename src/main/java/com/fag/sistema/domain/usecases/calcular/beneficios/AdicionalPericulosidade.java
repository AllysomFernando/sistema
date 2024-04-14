package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;

import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.enums.EnumGrauInsalubridade;

import org.springframework.stereotype.Service;

@Service
public class AdicionalPericulosidade implements IBeneficioUseCase {

  @Override
  public BigDecimal calculate(Empregado empregado) {
    EnumGrauInsalubridade grauInsalubridade = empregado.getContrato().getGrauInsalubridade();

    if (grauInsalubridade != EnumGrauInsalubridade.NULO) {
      return BigDecimal.ZERO;
    }

    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();
    return salarioBruto.multiply(new BigDecimal("0.3"));
  }

}
