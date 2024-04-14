package com.fag.sistema.domain.usecases.calcular.descontos;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.fag.sistema.domain.entities.empregado.Empregado;

@Service
public class ValeAlimentacao implements IDescontoUseCase {

  @Override
  public BigDecimal calculate(Empregado empregado) {

    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();

    return salarioBruto.multiply(new BigDecimal("0.15")).setScale(2, RoundingMode.DOWN);
  }

}
