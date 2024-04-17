package com.fag.sistema.domain.usecases.calcular.descontos;

import java.math.BigDecimal;
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
    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();
    BigDecimal horasEmDeficit = new BigDecimal(empregado.getHorario().getHorasEmDeficit()).setScale(2, RoundingMode.DOWN);
    Float diasTrabalhados = empregado.getHorario().getHoraTrabalhada() / empresa.getCargaHorariaDiaria();

    BigDecimal valorDiaria = salarioBruto.divide(new BigDecimal(diasTrabalhados).setScale(2, RoundingMode.HALF_EVEN)).setScale(2, RoundingMode.CEILING);

    BigDecimal valorHoras = valorDiaria.divide(new BigDecimal(empresa.getCargaHorariaDiaria())).setScale(2, RoundingMode.DOWN);

    BigDecimal desconto = valorHoras.multiply(horasEmDeficit);

    this.setProvento(getDescricao(), horasEmDeficit, BigDecimal.ZERO, desconto);

    empregado.getContrato().getSalario().setBaseCalculoFGTS(desconto.negate());
    empregado.getContrato().getSalario().setBaseCalculoInss(desconto.negate());

    return desconto;

  }

}
