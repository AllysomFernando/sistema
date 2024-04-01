package com.fag.sistema.domain.usecases.calcular.descontos;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.fag.sistema.domain.entities.Empregado;

public class ValeTransporte implements IDescontoUseCase {

  @Override
  public BigDecimal calculate(Empregado empregado) {
    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();
    return salarioBruto.multiply(new BigDecimal("0.03")).setScale(2, RoundingMode.DOWN);
  }
  
}