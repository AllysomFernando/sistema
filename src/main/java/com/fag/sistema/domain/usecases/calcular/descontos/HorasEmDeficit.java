package com.fag.sistema.domain.usecases.calcular.descontos;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import com.fag.sistema.domain.entities.Provento;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empresa;

public class HorasEmDeficit extends Provento implements IDescontoUseCase {

  public HorasEmDeficit() {
    this.setDescricao("Horas em Deficit");
  }

  @Override
  public BigDecimal calculate(Empregado empregado, Empresa empresa) {

    if (empregado.getHorario().getJustificativa()) return BigDecimal.ZERO;

    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();
    BigDecimal horasEmDeficit = new BigDecimal(empregado.getHorario().getHorasEmDeficit()).setScale(2, RoundingMode.DOWN);
    Float diasTrabalhados = empregado.getHorario().getHoraTrabalhada() / empresa.getCargaHorariaDiaria();

    BigDecimal diasTrabalhadosBigDecimal = new BigDecimal(Float.toString(diasTrabalhados));

    BigDecimal valorDiaria = salarioBruto.divide(diasTrabalhadosBigDecimal, MathContext.DECIMAL128);

    BigDecimal valorHoras = valorDiaria.divide(new BigDecimal(empresa.getCargaHorariaDiaria())).setScale(2, RoundingMode.HALF_DOWN);

    BigDecimal desconto = valorHoras.multiply(horasEmDeficit).setScale(2);

    this.setProvento(getDescricao(), horasEmDeficit, BigDecimal.ZERO, desconto);

    empregado.getContrato().getSalario().setBaseCalculoFGTS(desconto.negate());
    empregado.getContrato().getSalario().setBaseCalculoInss(desconto.negate());

    return desconto;

  }

}
