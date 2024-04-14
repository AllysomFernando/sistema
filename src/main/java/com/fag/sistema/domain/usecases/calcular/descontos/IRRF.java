package com.fag.sistema.domain.usecases.calcular.descontos;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.fag.sistema.domain.entities.Provento;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.enums.RelacaoIRRF;


public class IRRF extends Provento implements IDescontoUseCase {

  public IRRF() {
    this.setDescricao("IRRF");
  }

  @Override
  public BigDecimal calculate(Empregado empregado) {

    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();
    BigDecimal referencia = new BigDecimal("0");
    BigDecimal discountValue = new BigDecimal("0");
    RelacaoIRRF[] relacaoIrrf = RelacaoIRRF.values();

    for (RelacaoIRRF element : relacaoIrrf) {
      if (element.compare(salarioBruto)) {
        referencia = element.getReferencia();
        discountValue = salarioBruto.multiply(referencia);
        break;
      }
    }

    this.setProvento(getDescricao(), referencia, BigDecimal.ZERO, discountValue);

    return discountValue.setScale(2, RoundingMode.DOWN);
  }

}
