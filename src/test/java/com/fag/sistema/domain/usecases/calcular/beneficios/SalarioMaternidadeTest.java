package com.fag.sistema.domain.usecases.calcular.beneficios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import com.fag.sistema.service.beneficio.SalarioMaternidade;
import org.junit.jupiter.api.Test;

import com.fag.sistema.domain.entities.Contrato;
import com.fag.sistema.domain.entities.Empregado;
import com.fag.sistema.domain.entities.Salario;

public class SalarioMaternidadeTest {
  private Empregado makeEmpregado(BigDecimal salarioBruto) {
    Empregado empregado = new Empregado();
    empregado.setContrato(new Contrato());
    empregado.getContrato().setSalario(new Salario(salarioBruto));

    return empregado;
  }

  @Test
  void shouldCalculateSalarioMaternidade() {
    SalarioMaternidade sut = new SalarioMaternidade();
    Empregado empregado = makeEmpregado(new BigDecimal("2000.00"));

    BigDecimal beneficio = sut.calculate(empregado);

    assertEquals(new BigDecimal("100.00"), beneficio);
  }
}
