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

}
