package com.fag.sistema.domain.usecases.calcular.beneficios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import com.fag.sistema.domain.entities.Contrato;
import com.fag.sistema.domain.entities.Dependente;
import com.fag.sistema.domain.entities.Empregado;
import com.fag.sistema.domain.entities.Salario;

public class AuxilioCrecheTest {
  private Empregado makeEmpregado(BigDecimal salarioBruto) {
    Empregado empregado = new Empregado();
    empregado.setContrato(new Contrato());
    empregado.getContrato().setSalario(new Salario(salarioBruto));

    return empregado;
  }

  private List<Dependente> makeDependentes() {
    List<Dependente> dependentes = List.of(
        new Dependente("Rosie Robbins", LocalDate.of(2024, 01, 01)),
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
  @Description("Should not add auxilio creche if empregado has no dependente")
  void shouldNotAddAuxilioCrecheIfEmpregadoHasNoDependente() {
    AuxilioCreche sut = new AuxilioCreche();
    Empregado empregado = makeEmpregado(new BigDecimal("1900.00"));

    BigDecimal beneficio = sut.calculate(empregado);

    assertEquals(new BigDecimal("0.00"), beneficio);
  }

  @Test
  @Description("Should add auxilio creche for two dependentes")
  void shouldAddAuxilioCrecheForEachDependente() {
    AuxilioCreche sut = new AuxilioCreche();
    Empregado empregado = makeEmpregado(new BigDecimal("1900.00"));
    List<Dependente> dependentes = makeDependentes();

    empregado.setDependentes(dependentes);

    BigDecimal beneficio = sut.calculate(empregado);

    assertEquals(new BigDecimal("190.00"), beneficio);
  }

  @Test
  @Description("Should add auxilio creche for one dependentes")
  void shouldAddAuxilioCrecheForOneDependente() {
    AuxilioCreche sut = new AuxilioCreche();
    Empregado empregado = makeEmpregado(new BigDecimal("1900.00"));
    List<Dependente> dependentes = List.of(
      new Dependente("Rosie Robbins", LocalDate.of(2024, 01, 01))
    );

    empregado.setDependentes(dependentes);

    BigDecimal beneficio = sut.calculate(empregado);

    assertEquals(new BigDecimal("95.00"), beneficio);
  }

  @Test
  @Description("Should not add auxilio creche for each invalid dependente")
  void shouldNotAddAuxilioCrecheForEachDependente() {
    AuxilioCreche sut = new AuxilioCreche();
    Empregado empregado = makeEmpregado(new BigDecimal("1900.00"));
    List<Dependente> dependentes = makeInvalidDependentes();

    empregado.setDependentes(dependentes);

    BigDecimal beneficio = sut.calculate(empregado);

    assertEquals(new BigDecimal("0.00"), beneficio);
  }
}
