package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.fag.sistema.domain.entities.Empregado;
import com.fag.sistema.domain.enums.EnumGrauInsalubridade;

public class AdicionalInsalubridade implements IBeneficioUseCase {

  @Override
  public BigDecimal calculate(Empregado empregado) {
    EnumGrauInsalubridade insalubridade = empregado.getContrato().getGrauInsalubridade();
    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();

    BigDecimal beneficio = salarioBruto.multiply(insalubridade.getMultiplicador()); 
    
    return beneficio.setScale(2, RoundingMode.DOWN);
  }

}
