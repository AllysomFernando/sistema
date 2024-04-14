package com.fag.sistema.domain.usecases.calcular.descontos;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.fag.sistema.domain.entities.Provento;
import com.fag.sistema.domain.entities.empregado.Empregado;

@Service
public class ValeTransporte extends Provento implements IDescontoUseCase {

  public ValeTransporte() {
    this.setDescricao("Vale Transporte");
  }

  @Override
  public BigDecimal calculate(Empregado empregado) {
    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();
    BigDecimal referencia = new BigDecimal("0.05");
    BigDecimal desconto = salarioBruto.multiply(referencia).setScale(2, RoundingMode.DOWN);

    this.setProvento(getDescricao(), referencia, BigDecimal.ZERO, desconto);

    return desconto;
  }

}
