package com.fag.sistema.domain.usecases.calcular.descontos;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.fag.sistema.domain.entities.Empregado;

public class INSS implements IDescontoUseCase {

  @Override
  public BigDecimal calculate(Empregado empregado) {

    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();
    BigDecimal discountValue = new BigDecimal("642.34");

    boolean eightPercentDiscount = salarioBruto.compareTo(new BigDecimal("1751.81")) <= 0;

    boolean ninePercentDiscount = salarioBruto.compareTo(new BigDecimal("1751.82")) >= 0
        && salarioBruto.compareTo(new BigDecimal("2919.72")) <= 0;

    boolean elevenPercentDiscount = salarioBruto.compareTo(new BigDecimal("2919.73")) >= 0
        && salarioBruto.compareTo(new BigDecimal("5839.45")) <= 0;

    if (eightPercentDiscount) {
      discountValue = salarioBruto.multiply(new BigDecimal("0.08"));
    }

    if (ninePercentDiscount) {
      discountValue = salarioBruto.multiply(new BigDecimal("0.09"));
    }

    if (elevenPercentDiscount) {
      discountValue = salarioBruto.multiply(new BigDecimal("0.11"));
    }

    return discountValue.setScale(2, RoundingMode.DOWN);
  }

}
