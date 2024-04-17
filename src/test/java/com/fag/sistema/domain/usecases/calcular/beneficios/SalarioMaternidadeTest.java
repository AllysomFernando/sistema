package com.fag.sistema.domain.usecases.calcular.beneficios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.fag.sistema.domain.entities.empregado.Beneficios;
import com.fag.sistema.domain.entities.empregado.Contrato;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empregado.Salario;
import com.fag.sistema.domain.entities.empresa.Empresa;

public class SalarioMaternidadeTest {
  private Empregado makeEmpregado(BigDecimal salarioBruto) {
    Empregado empregado = new Empregado();
    Contrato contrato = new Contrato();
    contrato.setBeneficios(new Beneficios(false, false, true));
    contrato.setSalario(new Salario(salarioBruto));

    empregado.setContrato(contrato);

    return empregado;
  }


  private Empresa makeEmpresa() {
    Empresa empresa = new Empresa();

    return empresa;
  }

  @Test
  void shouldCalculateSalarioMaternidade() {
    SalarioMaternidade sut = new SalarioMaternidade();
    Empregado empregado = makeEmpregado(new BigDecimal("2000.00"));

    Empresa empresa = makeEmpresa();

    BigDecimal beneficio = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("100.00"), beneficio);
  }
}
