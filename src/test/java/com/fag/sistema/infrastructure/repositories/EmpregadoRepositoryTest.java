package com.fag.sistema.infrastructure.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fag.sistema.domain.entities.empregado.Empregado;

public class EmpregadoRepositoryTest {

  @Test
  void shouldReturnAListOfEmpregados() {
    EmpregadoRepository sut = new EmpregadoRepository();

    List<Empregado> empregados = sut.getAllEmpregados();

    assertNotNull(empregados);
    assertEquals(1, empregados.size());
    assertNotNull(empregados.get(0).getCpf());
  }

  @Test
  void shouldReturnAEmpregadoByCpf() {
    EmpregadoRepository sut = new EmpregadoRepository();

    Empregado empregado = sut.getEmpregadoByCPF("12345678910");

    assertNotNull(empregado);
    assertEquals("12345678910", empregado.getCpf());
    assertNotNull(empregado.getCpf());
  }
}
