package com.fag.sistema.domain.usecases.calcular.beneficios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import com.fag.sistema.domain.entities.empregado.Contrato;
import com.fag.sistema.domain.entities.empregado.Dependente;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empregado.Salario;
import com.fag.sistema.domain.entities.empresa.Empresa;
import com.fag.sistema.domain.enums.EnumGenero;

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

  private List<Empregado> makeEmpregadosComDependente() {
    List<Empregado> empregados = new ArrayList<>();
    List<Dependente> dependentes = this.makeDependentes();

    for (int i = 0; i < 30; i++) {
      Empregado funcionaria = new Empregado();
      funcionaria.setNome("Kyle Nichols");
      funcionaria.setGenero(EnumGenero.FEMININO);
      funcionaria.setDataNascimento(LocalDate.of(2000, 03, 01));
      funcionaria.setDependentes(dependentes);

      empregados.add(funcionaria);
    }

    return empregados;
  }

  private Empresa makeEmpresa() {
    Empresa empresa = new Empresa();
    empresa.setEmpregados(this.makeEmpregadosComDependente());

    return empresa;
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
    AuxilioCreche sut = new AuxilioCreche();
    Empregado empregado = makeEmpregado(new BigDecimal("2000"));
    Empresa empresa = makeEmpresa();
    List<Dependente> dependentes = List.of(
        new Dependente("Rosie Robbins", LocalDate.of(2024, 01, 01)));
        empregado.setDependentes(dependentes);

    sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("2100.00"), empregado.getContrato().getSalario().getBaseCalculoInss());
    assertEquals(new BigDecimal("2100.00"), empregado.getContrato().getSalario().getBaseCalculoFGTS());
    assertEquals(new BigDecimal("2100.00"), empregado.getContrato().getSalario().getBaseCalculoIRRF());
  }

  @Test
  @Description("Should not add auxilio creche if empregado has no dependente")
  void shouldNotAddAuxilioCrecheIfEmpregadoHasNoDependente() {
    AuxilioCreche sut = new AuxilioCreche();
    Empregado empregado = makeEmpregado(new BigDecimal("1900.00"));
    Empresa empresa = makeEmpresa();

    BigDecimal beneficio = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("0.00"), beneficio);
  }

  @Test
  @Description("Should add auxilio creche for two dependentes")
  void shouldAddAuxilioCrecheForEachDependente() {
    AuxilioCreche sut = new AuxilioCreche();
    Empregado empregado = makeEmpregado(new BigDecimal("1900.00"));
    List<Dependente> dependentes = makeDependentes();

    empregado.setDependentes(dependentes);
    Empresa empresa = makeEmpresa();

    BigDecimal beneficio = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("190.00"), beneficio);
  }

  @Test
  @Description("Should add auxilio creche for one dependentes")
  void shouldAddAuxilioCrecheForOneDependente() {
    AuxilioCreche sut = new AuxilioCreche();
    Empregado empregado = makeEmpregado(new BigDecimal("1900.00"));
    List<Dependente> dependentes = List.of(
        new Dependente("Rosie Robbins", LocalDate.of(2024, 01, 01)));

    empregado.setDependentes(dependentes);
    Empresa empresa = makeEmpresa();

    BigDecimal beneficio = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("95.00"), beneficio);
  }

  @Test
  @Description("Should not add auxilio creche for each invalid dependente")
  void shouldNotAddAuxilioCrecheForEachDependente() {
    AuxilioCreche sut = new AuxilioCreche();
    Empregado empregado = makeEmpregado(new BigDecimal("1900.00"));
    List<Dependente> dependentes = makeInvalidDependentes();

    empregado.setDependentes(dependentes);
    Empresa empresa = makeEmpresa();

    BigDecimal beneficio = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("0.00"), beneficio);
  }

  @Test
  @Description("Should not change base de calculo de inss, fgts e irrf")
  void shouldNotchangeBaseDeCalculo() {
    AuxilioCreche sut = new AuxilioCreche();
    Empregado empregado = makeEmpregado(new BigDecimal("3000"));
    Empresa empresa = makeEmpresa();

    sut.calculate(empregado, empresa);

    assertEquals(empregado.getContrato().getSalario().getBruto(), empregado.getContrato().getSalario().getBaseCalculoFGTS());
    assertEquals(empregado.getContrato().getSalario().getBruto(), empregado.getContrato().getSalario().getBaseCalculoInss());
  }
}
