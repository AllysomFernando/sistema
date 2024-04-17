package com.fag.sistema.domain.usecases.calcular.beneficios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.fag.sistema.domain.entities.empregado.Contrato;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empregado.Salario;
import com.fag.sistema.domain.entities.empresa.Empresa;

public class QuinquenioTest {

  private Empregado makeEmpregado(BigDecimal salarioBruto, LocalDate dataAdmissao) {
    Empregado empregado = new Empregado();
    empregado.setContrato(new Contrato());
    empregado.getContrato().setSalario(new Salario(salarioBruto));
    empregado.getContrato().setDataAdmissao(dataAdmissao);

    return empregado;
  }


  private Empresa makeEmpresa() {
    Empresa empresa = new Empresa();

    return empresa;
  }

  @Test
  void shouldCalculateQuiquenioForEmpregadoWith5Years() {
    Quinquenio sut = new Quinquenio();
    LocalDate dataAdmissao = LocalDate.of(LocalDate.now().getYear() - 5, LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth());
    Empregado empregado = makeEmpregado(new BigDecimal("2000.00"), dataAdmissao);

    Empresa empresa = makeEmpresa();

    BigDecimal beneficio = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("60.00"), beneficio);
  }

  @Test
  void shouldCalculateQuiquenioForEmpregadoWith10Years() {
    Quinquenio sut = new Quinquenio();
    LocalDate dataAdmissao = LocalDate.of(LocalDate.now().getYear() - 10, LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth());
    Empregado empregado = makeEmpregado(new BigDecimal("2000.00"), dataAdmissao);
    Empresa empresa = makeEmpresa();

    BigDecimal beneficio = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("120.00"), beneficio);
  }

  @Test
  void shouldCalculateQuiquenioForEmpregadoWith6Years() {
    Quinquenio sut = new Quinquenio();
    LocalDate dataAdmissao = LocalDate.of(LocalDate.now().getYear() - 6, LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth());
    Empregado empregado = makeEmpregado(new BigDecimal("2000.00"), dataAdmissao);

    Empresa empresa = makeEmpresa();

    BigDecimal beneficio = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("60.00"), beneficio);
  }

}
