package com.fag.sistema.domain.usecases.calcular.descontos;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.fag.sistema.domain.entities.Empregado;

public class IRRF implements IDescontoUseCase {

  @Override
  public BigDecimal calculate(Empregado empregado) {

    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();

    boolean sevenAndHalfPercent = salarioBruto.compareTo(new BigDecimal("1903.99")) >= 0
        && salarioBruto.compareTo(new BigDecimal("2826.65")) <= 0;

    boolean fifteenPercent = salarioBruto.compareTo(new BigDecimal("2826.66")) >= 0
        && salarioBruto.compareTo(new BigDecimal("3751.05")) <= 0;

    boolean twentyTwoAndHalfPercent = salarioBruto.compareTo(new BigDecimal("3751.06")) >= 0
        && salarioBruto.compareTo(new BigDecimal("4664.68")) <= 0;

    boolean twentySevenAndHalfPercent = salarioBruto.compareTo(new BigDecimal("4664.68")) >= 0;

    BigDecimal discountValue = new BigDecimal("0");

    if (sevenAndHalfPercent) {
      discountValue = salarioBruto.multiply(new BigDecimal("0.075"));
    }

    if (fifteenPercent) {
      discountValue = salarioBruto.multiply(new BigDecimal("0.15"));
    }

    if (twentySevenAndHalfPercent) {
      discountValue = salarioBruto.multiply(new BigDecimal("0.225"));
    }

    if (twentyTwoAndHalfPercent) {
      discountValue = salarioBruto.multiply(new BigDecimal("0.275"));
    }

    return discountValue.setScale(2, RoundingMode.DOWN);
  }

}
