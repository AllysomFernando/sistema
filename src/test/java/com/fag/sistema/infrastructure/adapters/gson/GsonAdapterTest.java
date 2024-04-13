package com.fag.sistema.infrastructure.adapters.gson;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fag.sistema.domain.entities.Empregador;

public class GsonAdapterTest {

  @Test
  void shouldNotThrowIfValidResourceIsGiven() {
    GsonAdapter<Object> sut = new GsonAdapter<Object>("data.json");

    assertNotNull(sut.getResource());
    assertDoesNotThrow(() -> {
      sut.getResource();
    });
  }

  @Test
  void shouldThrowIfInvalidResourceIsGiven() {
    GsonAdapter<Object> sut = new GsonAdapter<Object>("invalid-file.json");

    assertThrows(RuntimeException.class, () -> {
      sut.getResource();
    });
  }

  @Test
  void shouldReadJsonContentAsList() {
    GsonAdapter<Empregador> sut = new GsonAdapter<Empregador>("data.json");

    List<Empregador> empregadores = sut.readListFromJson(Empregador[].class);

    assertNotNull(empregadores);
    assertEquals(1, empregadores.size());

  }

}
