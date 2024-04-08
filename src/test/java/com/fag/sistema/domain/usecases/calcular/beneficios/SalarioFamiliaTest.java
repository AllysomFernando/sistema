package com.fag.sistema.domain.usecases.calcular.beneficios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

import com.fag.sistema.service.beneficio.SalarioFamilia;
import org.junit.jupiter.api.Test;

import com.fag.sistema.domain.entities.Contrato;
import com.fag.sistema.domain.entities.Dependente;
import com.fag.sistema.domain.entities.Empregado;
import com.fag.sistema.domain.entities.Salario;

public class SalarioFamiliaTest {
  private Empregado makeEmpregado(BigDecimal salarioBruto) {
    Empregado empregado = new Empregado();
    empregado.setContrato(new Contrato());
    empregado.getContrato().setSalario(new Salario(salarioBruto));

    return empregado;
  }

  private List<Dependente> makeValidDependentes() {
    List<Dependente> dependentes = List.of(
        new Dependente("Rosie Robbins", LocalDate.of(2020, 01, 01)),
        new Dependente("Katherine Holt", LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.SUNDAY))));

    return dependentes;
  }

  private List<Dependente> makeInvalidDependentes() {
    List<Dependente> dependentes = List.of(
        new Dependente("Rosie Robbins", LocalDate.of(2000, 01, 01)),
        new Dependente("Katherine Holt", LocalDate.of(1980, 07, 26)));

    return dependentes;
  }

  @Test
  void shouldCalculateSalarioFamiliaForOneDependente() {
    SalarioFamilia sut = new SalarioFamilia();
    Empregado empregado = makeEmpregado(new BigDecimal("2000.00"));

    List<Dependente> dependentes = List.of(
        new Dependente("Rosie Robbins", LocalDate.of(2020, 01, 01)));

    empregado.setDependentes(dependentes);

    BigDecimal beneficio = sut.calculate(empregado);

    assertEquals(new BigDecimal("70.60"), beneficio);
  }

  @Test
  void shouldCalculateSalarioFamiliaForTwoDependentes() {
    SalarioFamilia sut = new SalarioFamilia();
    Empregado empregado = makeEmpregado(new BigDecimal("2000.00"));
    List<Dependente> dependentes = makeValidDependentes();

    empregado.setDependentes(dependentes);

    BigDecimal beneficio = sut.calculate(empregado);

    assertEquals(new BigDecimal("141.20"), beneficio);
  }

  @Test
  void shouldCalculateSalarioFamiliaForInvalidDependentes() {
    SalarioFamilia sut = new SalarioFamilia();
    Empregado empregado = makeEmpregado(new BigDecimal("2000.00"));
    List<Dependente> dependentes = makeInvalidDependentes();

    empregado.setDependentes(dependentes);

    BigDecimal beneficio = sut.calculate(empregado);

    assertEquals(new BigDecimal("0.00"), beneficio);
  }
}
