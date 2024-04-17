package com.fag.sistema.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fag.sistema.domain.entities.empregado.Empregado;

@SpringBootTest
public class EmpregadoServiceTest {

  @Autowired
  private EmpregadoService sut;
  
  @Test
  void shouldReturnAllEmpregados() {
    List<Empregado> empregados = this.sut.getAllEmpregados();

    assertTrue(empregados.size() > 0);
  }
}
