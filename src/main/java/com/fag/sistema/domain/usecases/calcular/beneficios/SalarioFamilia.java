package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fag.sistema.domain.entities.Provento;
import com.fag.sistema.domain.entities.empregado.Dependente;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empresa;

@Component
public class SalarioFamilia extends Provento implements IBeneficioUseCase {

  private final BigDecimal SALARIO_MINIMO = new BigDecimal("1412.00");

  public SalarioFamilia() {
    super("Salário Família");
  }

  @Override
  public BigDecimal calculate(Empregado empregado, Empresa empresa) {
    BigDecimal beneficio = BigDecimal.ZERO.setScale(2, RoundingMode.DOWN);
    Float quantidadeDependentesValidos = 0.0f;

    if (!empregado.possuiDependente()) return beneficio;

    List<Dependente> dependentes = empregado.getDependentes();

    for (Dependente d : dependentes) {
      LocalDate now = LocalDate.now();
      Long diferencaEmAnos = ChronoUnit.YEARS.between(d.getDataNascimento(), now);

      if (diferencaEmAnos < 14l) {
        quantidadeDependentesValidos++;
        beneficio = beneficio.add(getBeneficio());
      }
    }

    this.setProvento(getDescricao(), quantidadeDependentesValidos, beneficio, BigDecimal.ZERO);
    empregado.getContrato().getSalario().somarBasesDeCalculo(beneficio);

    return beneficio;
  }

  private BigDecimal getBeneficio() {
    BigDecimal referencia = new BigDecimal("0.05");

    this.setReferencia(referencia);

    return this.SALARIO_MINIMO.multiply(referencia).setScale(2, RoundingMode.DOWN);
  }

}
