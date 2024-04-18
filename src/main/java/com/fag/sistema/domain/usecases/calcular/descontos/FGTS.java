package com.fag.sistema.domain.usecases.calcular.descontos;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.fag.sistema.domain.entities.Provento;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empresa;

@Component
@Order(6)
public class FGTS extends Provento implements IDescontoEmFolhaUseCase {

  public FGTS() {
    this.setDescricao("FGTS");
  }

  public BigDecimal calculate(Empregado empregado, Empresa empresa) {
    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();
    BigDecimal referencia = new BigDecimal("0.08");
    BigDecimal desconto = salarioBruto.multiply(referencia).setScale(2, RoundingMode.DOWN);

    this.setProvento(getDescricao(), referencia, BigDecimal.ZERO, desconto);
    empregado.getContrato().getSalario().setFgtsMensal(desconto);

    return desconto;
  }

}
