package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.fag.sistema.domain.entities.Empregado;
import com.fag.sistema.domain.enums.EnumHorarioTrabalho;

public class AdicionalNoturno implements IBeneficioUseCase {

  // TODO: Baseado no valor da hora ou no salario bruto?
  @Override
  public BigDecimal calculate(Empregado empregado) {
    EnumHorarioTrabalho horarioTrabalho = empregado.getContrato().getHorarioTrabalho();

    if (horarioTrabalho == EnumHorarioTrabalho.NOTURNO) {
      BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();
      return salarioBruto.multiply(new BigDecimal("0.15")).setScale(2, RoundingMode.DOWN);
    }

    return BigDecimal.ZERO;
  }

}
