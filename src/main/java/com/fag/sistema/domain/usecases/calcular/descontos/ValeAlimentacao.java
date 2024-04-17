package com.fag.sistema.domain.usecases.calcular.descontos;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

import com.fag.sistema.domain.entities.Provento;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empresa;

@Component
public class ValeAlimentacao extends Provento implements IDescontoUseCase {

  public ValeAlimentacao() {
    this.setDescricao("Vale Alimentação");
  }

  @Override
  public BigDecimal calculate(Empregado empregado, Empresa empresa) {
    if (!empregado.getContrato().getBeneficios().getValeAlimentacao()) return BigDecimal.ZERO;

    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();
    BigDecimal referencia = new BigDecimal("0.1");
    BigDecimal desconto = salarioBruto.multiply(referencia).setScale(2, RoundingMode.DOWN);

    this.setProvento(getDescricao(), referencia, BigDecimal.ZERO, desconto);
    empregado.getContrato().getSalario().setBaseCalculoInss(desconto.negate());

    return desconto;
  }

}
