package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.fag.sistema.domain.entities.Dependente;
import com.fag.sistema.domain.entities.Empregado;

public class AuxilioCreche implements IBeneficioUseCase {

  @Override
  public BigDecimal calculate(Empregado empregado) {
    BigDecimal beneficio = BigDecimal.ZERO.setScale(2, RoundingMode.DOWN);

    if (empregado.getDependente() == null || empregado.getDependente().isEmpty())
      return beneficio;

    List<Dependente> dependentes = empregado.getDependente();
    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();

    for (Dependente d : dependentes) {
      LocalDate now = LocalDate.now();
      Long diferencaEmMeses = ChronoUnit.MONTHS.between(d.getDataNascimento(), now);
      if (diferencaEmMeses < 6) {
        BigDecimal auxilioCreche = salarioBruto.multiply(new BigDecimal("0.05")).setScale(2, RoundingMode.HALF_UP);
        beneficio = beneficio.add(auxilioCreche);
      }
    }

    return beneficio;
  }

}
