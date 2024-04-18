package com.fag.sistema.domain.usecases.calcular.beneficios;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import com.fag.sistema.domain.entities.empregado.Contrato;
import com.fag.sistema.domain.entities.empregado.Dependente;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empregado.Salario;
import com.fag.sistema.domain.entities.empresa.Empresa;

public class SalarioFamiliaTest {
  private Empregado makeEmpregado(BigDecimal salarioBruto) {
    Empregado empregado = new Empregado();
    empregado.setContrato(new Contrato());
    empregado.getContrato().setSalario(new Salario(salarioBruto));

    return empregado;
  }

  private Empresa makeEmpresa() {
    Empresa empresa = new Empresa();

    return empresa;
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
  @Description("Should update base de calculos")
  public void shouldUpdateBaseDeCalculos() {
    SalarioFamilia sut = new SalarioFamilia();
    Empregado empregado = makeEmpregado(new BigDecimal("2000.00"));
    Empresa empresa = makeEmpresa();
    List<Dependente> dependentes = List.of(
        new Dependente("Rosie Robbins", LocalDate.of(2020, 01, 01)));

    empregado.setDependentes(dependentes);

    sut.calculate(empregado, empresa);

    assertAll("Bases de calculos",
        () -> assertEquals(new BigDecimal("2070.60"), empregado.getContrato().getSalario().getBaseCalculoInss()),
        () -> assertEquals(new BigDecimal("2070.60"), empregado.getContrato().getSalario().getBaseCalculoFGTS()),
        () -> assertEquals(new BigDecimal("2070.60"), empregado.getContrato().getSalario().getBaseCalculoIRRF()));
  }

  @Test
  void shouldCalculateSalarioFamiliaForOneDependente() {
    SalarioFamilia sut = new SalarioFamilia();
    Empregado empregado = makeEmpregado(new BigDecimal("2000.00"));

    Empresa empresa = makeEmpresa();

    List<Dependente> dependentes = List.of(
        new Dependente("Rosie Robbins", LocalDate.of(2020, 01, 01)));

    empregado.setDependentes(dependentes);

    BigDecimal beneficio = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("70.60"), beneficio);
  }

  @Test
  void shouldCalculateSalarioFamiliaForTwoDependentes() {
    SalarioFamilia sut = new SalarioFamilia();
    Empregado empregado = makeEmpregado(new BigDecimal("2000.00"));
    List<Dependente> dependentes = makeValidDependentes();
    Empresa empresa = makeEmpresa();

    empregado.setDependentes(dependentes);

    BigDecimal beneficio = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("141.20"), beneficio);
  }

  @Test
  void shouldCalculateSalarioFamiliaForInvalidDependentes() {
    SalarioFamilia sut = new SalarioFamilia();
    Empregado empregado = makeEmpregado(new BigDecimal("2000.00"));
    List<Dependente> dependentes = makeInvalidDependentes();
    Empresa empresa = makeEmpresa();

    empregado.setDependentes(dependentes);

    BigDecimal beneficio = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("0.00"), beneficio);
  }
}
