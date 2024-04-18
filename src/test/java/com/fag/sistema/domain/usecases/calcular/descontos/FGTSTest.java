package com.fag.sistema.domain.usecases.calcular.descontos;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.fag.sistema.domain.entities.empregado.Contrato;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empregado.Salario;
import com.fag.sistema.domain.entities.empresa.Empresa;

public class FGTSTest {

  private Empresa makeEmpresa() {
    Empresa empresa = new Empresa();

    return empresa;
  }

  private Empregado makeEmpregado() {
    Empregado empregado = new Empregado();
    BigDecimal salarioBruto = new BigDecimal("3000");
    empregado.setContrato(new Contrato());
    empregado.getContrato().setSalario(new Salario(salarioBruto));

    return empregado;
  }

  @Test
  public void shouldCalculateFGTSIfSalaryIsThreeThousand() {
    FGTS sut = new FGTS();
    Empregado empregado = makeEmpregado();
    Empresa empresa = makeEmpresa();

    BigDecimal discount = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("240.00"), discount);
  }

  @Test
  void shouldSetFgtsMensal() {
    FGTS sut = new FGTS();
    Empregado empregado = makeEmpregado();
    Empresa empresa = makeEmpresa();

    BigDecimal discount = sut.calculate(empregado, empresa);

    assertEquals(discount, empregado.getContrato().getSalario().getFgtsMensal());
  }

  @Test
  void shouldNotUpdateBaseDeCalculos() {
    FGTS sut = new FGTS();
    Empregado empregado = makeEmpregado();
    Empresa empresa = makeEmpresa();

    sut.calculate(empregado, empresa);

    assertAll("Base de Calculo",
        () -> assertEquals(new BigDecimal("3000.00"), empregado.getContrato().getSalario().getBaseCalculoInss()),
        () -> assertEquals(new BigDecimal("3000.00"), empregado.getContrato().getSalario().getBaseCalculoFGTS()),
        () -> assertEquals(new BigDecimal("3000.00"), empregado.getContrato().getSalario().getBaseCalculoIRRF()));

  }
}
