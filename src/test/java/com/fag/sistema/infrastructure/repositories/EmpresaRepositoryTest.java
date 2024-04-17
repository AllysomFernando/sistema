package com.fag.sistema.infrastructure.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empresa;

@SpringBootTest
@ActiveProfiles("test")
public class EmpresaRepositoryTest {

  @Autowired
  private EmpresaRepository sut;
  
  @Test
  void shouldReturnAListOfEmpresas() {
    List<Empresa> empresas = sut.getAllEmpregador();

    assertNotNull(empresas);
    assertEquals(1, empresas.size());
    assertNotNull(empresas.get(0).getCnpj());
  }

  @Test
  void shouldAllEmpregadosFeminino() {
    List<Empregado> funcionarias = sut.getAllFuncionariosMulheresByEmpresaCnpj("12345678000122");

    assertEquals(1, funcionarias.size());
  }
}
