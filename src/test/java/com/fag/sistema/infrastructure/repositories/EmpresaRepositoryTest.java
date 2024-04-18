package com.fag.sistema.infrastructure.repositories;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empresa;
import com.fag.sistema.domain.enums.EnumTipoContrato;

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

  @Test
  void shouldGetAllFuncionariosWithSalarioMaternidade() {
    List<Empregado> funcionarios = sut.getAllFuncionariasComSalarioMaternidade("12345678000122");

    assertEquals(1, funcionarios.size());
    assertEquals("97766548356", funcionarios.get(0).getCpf());
  }

  @Test
  void shouldGroupFuncionariosByCategoria() {
    HashMap<String, List<Empregado>> funcionarios = sut.getAllFuncionariosGroupByCategoria("12345678000122");

    assertEquals(3, funcionarios.size());

    assertAll("Tipos de contrato",
        () -> assertTrue(funcionarios.containsKey(EnumTipoContrato.CLT.name().toLowerCase())),
        () -> assertTrue(funcionarios.containsKey(EnumTipoContrato.ESTAGIO.name().toLowerCase())),
        () -> assertTrue(funcionarios.containsKey(EnumTipoContrato.PJ.name().toLowerCase())));
  }
}
