package com.fag.sistema.domain.usecases.calcular.descontos;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

import com.fag.sistema.domain.entities.Provento;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.enums.RelacaoIRRF;

@Component
public class IRRF extends Provento implements IDescontoUseCase {

  public IRRF() {
    this.setDescricao("IRRF");
  }

  @Override
  public BigDecimal calculate(Empregado empregado) {

    BigDecimal salarioParaIRRF = empregado.getContrato().getSalario().getBaseCalculoIRRF();
    BigDecimal referencia = new BigDecimal("0");
    BigDecimal discountValue = new BigDecimal("0");
    RelacaoIRRF[] relacaoIrrf = RelacaoIRRF.values();

    for (RelacaoIRRF element : relacaoIrrf) {
      if (element.compare(salarioParaIRRF)) {
        referencia = element.getReferencia();
        discountValue = salarioParaIRRF.multiply(referencia).setScale(2, RoundingMode.DOWN);
        break;
      }
    }

    this.setProvento(getDescricao(), referencia, BigDecimal.ZERO, discountValue);

    return discountValue.setScale(2);
  }

}
