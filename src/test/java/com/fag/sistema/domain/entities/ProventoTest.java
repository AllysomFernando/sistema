package com.fag.sistema.domain.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class ProventoTest {
  
  @Test
  void shouldParseBigDecimalToPercent() {
    Provento provento = new Provento();

    provento.setReferencia(new BigDecimal("0.15"));

    assertEquals(15.0f, provento.getReferencia());
  }

  @Test
  void shouldGetBigDecimalPercentage() {
    Provento provento = new Provento();

    Float value = provento.getPorcentagem(new BigDecimal("0.075"));

    assertEquals(7.5f, value);
  }


  @Test
  void shouldParseBigDecimalToPercent_Case2() {
    Provento provento = new Provento();

    provento.setReferencia(new BigDecimal("0.075"));

    assertEquals(7.5f, provento.getReferencia());
  }

  @Test
  void shouldNotHaveNullAttributes() {
    Provento provento = new Provento();

    assertEquals("", provento.getDescricao());
    assertEquals(0.0f, provento.getReferencia());
    assertEquals(BigDecimal.ZERO, provento.getDesconto());
    assertEquals(BigDecimal.ZERO, provento.getVencimento());
  }

}
