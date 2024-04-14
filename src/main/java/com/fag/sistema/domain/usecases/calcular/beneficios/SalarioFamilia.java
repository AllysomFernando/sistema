package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fag.sistema.domain.entities.empregado.Dependente;
import com.fag.sistema.domain.entities.empregado.Empregado;

@Service
public class SalarioFamilia implements IBeneficioUseCase {

  private final BigDecimal SALARIO_MINIMO = new BigDecimal("1412.00");

  @Override
  public BigDecimal calculate(Empregado empregado) {
    BigDecimal beneficio = BigDecimal.ZERO.setScale(2, RoundingMode.DOWN);

    if (empregado.getDependentes() == null || empregado.getDependentes().isEmpty()) {
      return beneficio;
    }

    List<Dependente> dependentes = empregado.getDependentes();

    for (Dependente d : dependentes) {
      LocalDate now = LocalDate.now();
      Long diferencaEmAnos = ChronoUnit.YEARS.between(d.getDataNascimento(), now);

      if (diferencaEmAnos < 14l) {
        beneficio = beneficio.add(getBeneficio());
      }
    }

    return beneficio;
  }

  private BigDecimal getBeneficio() {
    return this.SALARIO_MINIMO.multiply(new BigDecimal("0.05")).setScale(2, RoundingMode.DOWN);
  }

}
