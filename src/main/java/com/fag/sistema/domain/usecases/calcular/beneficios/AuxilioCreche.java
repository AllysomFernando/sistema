package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.fag.sistema.domain.entities.Provento;
import com.fag.sistema.domain.entities.empregado.Dependente;
import com.fag.sistema.domain.entities.empregado.Empregado;


public class AuxilioCreche extends Provento implements IBeneficioUseCase {

  public AuxilioCreche() {
    this.setDescricao("Auxilio Creche");
  }

  @Override
  public BigDecimal calculate(Empregado empregado) {
    BigDecimal beneficio = BigDecimal.ZERO.setScale(2, RoundingMode.DOWN);
    BigDecimal referencia = new BigDecimal("0.05");

    if (empregado.getDependentes() == null || empregado.getDependentes().isEmpty())
      return beneficio;

    List<Dependente> dependentes = empregado.getDependentes();
    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();

    for (Dependente d : dependentes) {
      LocalDate now = LocalDate.now();
      Long diferencaEmMeses = ChronoUnit.MONTHS.between(d.getDataNascimento(), now);
      if (diferencaEmMeses < 6) {
        BigDecimal auxilioCreche = salarioBruto.multiply(referencia).setScale(2, RoundingMode.HALF_UP);
        beneficio = beneficio.add(auxilioCreche);
      }
    }

    this.setProvento(getDescricao(), referencia, beneficio, BigDecimal.ZERO);

    return beneficio;
  }

}
