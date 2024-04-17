package com.fag.sistema.domain.usecases.calcular.beneficios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.fag.sistema.domain.entities.empregado.Contrato;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empregado.Salario;
import com.fag.sistema.domain.entities.empresa.Empregador;

public class SalarioMaternidadeTest {
  private Empregado makeEmpregado(BigDecimal salarioBruto) {
    Empregado empregado = new Empregado();
    empregado.setContrato(new Contrato());
    empregado.getContrato().setSalario(new Salario(salarioBruto));

    return empregado;
  }


  private Empregador makeEmpresa() {
    Empregador empresa = new Empregador();

    return empresa;
  }

  @Test
  void shouldCalculateSalarioMaternidade() {
    SalarioMaternidade sut = new SalarioMaternidade();
    Empregado empregado = makeEmpregado(new BigDecimal("2000.00"));

    Empregador empresa = makeEmpresa();

    BigDecimal beneficio = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("100.00"), beneficio);
  }
}
