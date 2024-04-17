package com.fag.sistema.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.fag.sistema.domain.entities.empregado.Empregado;

@SpringBootTest
@ActiveProfiles("test")
public class EmpregadoServiceTest {

  @Autowired
  private EmpregadoService sut;
  
  @Test
  void shouldReturnAllEmpregados() {
    List<Empregado> empregados = this.sut.getAllEmpregados();

    assertTrue(empregados.size() > 0);
  }

  @Test
  void shouldReturnEmpregadoByCpf() {
    String cpf = "12345678910";
    Empregado empregado = this.sut.findEmpregadoByCpf(cpf);

    assertEquals(cpf, empregado.getCpf());
    assertEquals("João Silva 2", empregado.getNome());
    assertEquals(LocalDate.of(1990, 01, 15), empregado.getDataNascimento());
  }
}
