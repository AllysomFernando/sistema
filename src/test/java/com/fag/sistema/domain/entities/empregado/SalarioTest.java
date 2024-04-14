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
}
