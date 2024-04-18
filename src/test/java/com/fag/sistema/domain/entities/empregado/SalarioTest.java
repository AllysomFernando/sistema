package com.fag.sistema.domain.entities.empregado;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class SalarioTest {

  @Test
  void shouldIncrementBasesDeCalculoEqualy() {
    Salario salario = new Salario(new BigDecimal("3000"));
    salario.somarBasesDeCalculo(new BigDecimal("300"));

    assertEquals(new BigDecimal("3300"), salario.getBaseCalculoFGTS());
    assertEquals(new BigDecimal("3300"), salario.getBaseCalculoInss());
    assertEquals(new BigDecimal("3300"), salario.getBaseCalculoIRRF());
  }

  @Test
  void basesDeCalculoShouldHaveSameValueOfSalarioBrutoOnInit() {
    Salario salario = new Salario(new BigDecimal("3000"));

    assertEquals(new BigDecimal("3000"), salario.getBaseCalculoFGTS());
    assertEquals(new BigDecimal("3000"), salario.getBaseCalculoInss());
    assertEquals(new BigDecimal("3000"), salario.getBaseCalculoIRRF());
  }

  @Test
  void basesDeCalculoShouldHaveSameValueOfSalarioBrutoOnInit_Case2() {
    Salario salario = new Salario();

    assertEquals(BigDecimal.ZERO, salario.getBaseCalculoFGTS());
    assertEquals(BigDecimal.ZERO, salario.getBaseCalculoInss());
    assertEquals(BigDecimal.ZERO, salario.getBaseCalculoIRRF());
  }

  @Test
  void shouldSubtractBasesDeCalculoEqualy() {
    Salario salario = new Salario(new BigDecimal("3000"));
    salario.subtrairBasesDeCalculo(new BigDecimal("300"));

    assertEquals(new BigDecimal("2700.00"), salario.getBaseCalculoFGTS());
    assertEquals(new BigDecimal("2700.00"), salario.getBaseCalculoInss());
    assertEquals(new BigDecimal("2700.00"), salario.getBaseCalculoIRRF());
  }

  @Test
  void shouldNotSubtractBasesDeCalculoIfTheyAreZero() {
    Salario salario = new Salario();
    salario.subtrairBasesDeCalculo(new BigDecimal("300"));

    assertEquals(BigDecimal.ZERO, salario.getBaseCalculoFGTS());
    assertEquals(BigDecimal.ZERO, salario.getBaseCalculoInss());
    assertEquals(BigDecimal.ZERO, salario.getBaseCalculoIRRF());
  }
}
