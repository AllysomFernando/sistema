package com.fag.sistema.domain.usecases.calcular.beneficios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.fag.sistema.domain.entities.Contrato;
import com.fag.sistema.domain.entities.Empregado;
import com.fag.sistema.domain.entities.Salario;

public class QuinquenioTest {

  private Empregado makeEmpregado(BigDecimal salarioBruto, LocalDate dataAdmissao) {
    Empregado empregado = new Empregado();
    empregado.setContrato(new Contrato());
    empregado.getContrato().setSalario(new Salario(salarioBruto));
    empregado.getContrato().setDataAdmissao(dataAdmissao);

    return empregado;
  }

  @Test
  void shouldCalculateQuiquenioForEmpregadoWith5Years() {
    Quinquenio sut = new Quinquenio();
    LocalDate dataAdmissao = LocalDate.of(LocalDate.now().getYear() - 5, LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth());
    Empregado empregado = makeEmpregado(new BigDecimal("2000.00"), dataAdmissao);

    BigDecimal beneficio = sut.calculate(empregado);

    assertEquals(new BigDecimal("60.00"), beneficio);
  }

  @Test
  void shouldCalculateQuiquenioForEmpregadoWith10Years() {
    Quinquenio sut = new Quinquenio();
    LocalDate dataAdmissao = LocalDate.of(LocalDate.now().getYear() - 10, LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth());
    Empregado empregado = makeEmpregado(new BigDecimal("2000.00"), dataAdmissao);

    BigDecimal beneficio = sut.calculate(empregado);

    assertEquals(new BigDecimal("120.00"), beneficio);
  }

  @Test
  void shouldCalculateQuiquenioForEmpregadoWith6Years() {
    Quinquenio sut = new Quinquenio();
    LocalDate dataAdmissao = LocalDate.of(LocalDate.now().getYear() - 6, LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth());
    Empregado empregado = makeEmpregado(new BigDecimal("2000.00"), dataAdmissao);

    BigDecimal beneficio = sut.calculate(empregado);

    assertEquals(new BigDecimal("60.00"), beneficio);
  }

}
