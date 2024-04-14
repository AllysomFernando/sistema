package com.fag.sistema.infrastructure.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fag.sistema.domain.entities.empresa.Empregador;

public class EmpresaRepositoryTest {
  
  @Test
  void shouldReturnAListOfEmpresas() {
    EmpresaRepository sut = new EmpresaRepository();
    List<Empregador> empresas = sut.getAllEmpregador();

    assertNotNull(empresas);
    assertEquals(1, empresas.size());
    assertNotNull(empresas.get(0).getCnpj());
  }
}
