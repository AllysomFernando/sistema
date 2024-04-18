package com.fag.sistema.domain.usecases.calcular.descontos;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.fag.sistema.domain.entities.Provento;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empresa;
import com.fag.sistema.domain.enums.RelacaoINSS;

@Component
@Order(1)
public class INSS extends Provento implements IDescontoUseCase {

  public INSS() {
    this.setDescricao("INSS");
  }

  @Override
  public BigDecimal calculate(Empregado empregado, Empresa empresa) {

    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBaseCalculoInss();
    BigDecimal discountValue = new BigDecimal("642.34");
    BigDecimal referencia = new BigDecimal("0");

    RelacaoINSS[] relacaoInss = RelacaoINSS.values();

    for (RelacaoINSS inss : relacaoInss) {
      if (inss.compare(salarioBruto)) {
        referencia = inss.getReferencia();
        discountValue = salarioBruto.multiply(referencia).setScale(2, RoundingMode.HALF_DOWN);
        
        break;
      }
    }

    empregado.getContrato().getSalario().subtrairBaseCalculoIrrf(discountValue);

    this.setProvento(getDescricao(), referencia, BigDecimal.ZERO, discountValue);

    return discountValue;
  }

}
