package com.fag.sistema.infrastructure.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fag.sistema.domain.entities.empregado.Empregado;

@SpringBootTest
public class EmpregadoRepositoryTest {

  @Autowired
  private EmpregadoRepository sut;

  @Test
  void shouldReturnAListOfEmpregados() {
    List<Empregado> empregados = sut.getAllEmpregados();

    assertNotNull(empregados);
    assertEquals(1, empregados.size());
    assertNotNull(empregados.get(0).getCpf());
  }

  @Test
  void shouldReturnAEmpregadoByCpf() {
    Empregado empregado = sut.getEmpregadoByCPF("12345678910");

    assertNotNull(empregado);
    assertEquals("12345678910", empregado.getCpf());
    assertNotNull(empregado.getCpf());
  }
}
