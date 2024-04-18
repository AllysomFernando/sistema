package com.fag.sistema.infrastructure.adapters.gson;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fag.sistema.domain.entities.empresa.Empresa;

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
    GsonAdapter<Empresa> sut = new GsonAdapter<Empresa>("data.json");

    List<Empresa> empregadores = sut.readListFromJson(Empresa[].class);

    assertNotNull(empregadores);
    assertTrue(empregadores.size() > 0);

  }

}
