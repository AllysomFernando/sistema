package com.fag.sistema.domain.usecases.calcular.descontos;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.fag.sistema.domain.entities.Provento;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empresa;
import com.fag.sistema.domain.enums.RelacaoIRRF;

@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class IRRF extends Provento implements IDescontoEmFolhaUseCase {

  public IRRF() {
    this.setDescricao("IRRF");
  }

  @Override
  public BigDecimal calculate(Empregado empregado, Empresa empresa) {

    BigDecimal salarioParaIRRF = empregado.getContrato().getSalario().getBaseCalculoIRRF();
    BigDecimal referencia = new BigDecimal("0");
    BigDecimal discountValue = new BigDecimal("0");
    RelacaoIRRF[] relacaoIrrf = RelacaoIRRF.values();

    for (RelacaoIRRF element : relacaoIrrf) {
      if (element.compare(salarioParaIRRF)) {
        referencia = element.getReferencia();
        BigDecimal porcentagemDoSalario = salarioParaIRRF.multiply(referencia).setScale(2, RoundingMode.DOWN);
        discountValue = porcentagemDoSalario.subtract(element.getDeducao());
        
        break;
      }
    }

    this.setProvento(getDescricao(), referencia, BigDecimal.ZERO, discountValue);

    return discountValue.setScale(2);
  }

}
