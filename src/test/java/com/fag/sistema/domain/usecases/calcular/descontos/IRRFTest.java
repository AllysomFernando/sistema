package com.fag.sistema.domain.usecases.calcular.descontos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import com.fag.sistema.domain.entities.empregado.Contrato;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empregado.Salario;

public class IRRFTest {

  private Empregado makeEmpregado(BigDecimal salarioBruto) {
    Empregado empregado = new Empregado();
    empregado.setContrato(new Contrato());
    empregado.getContrato().setSalario(new Salario(salarioBruto));

    return empregado;
  }

  @Test
  @Description("Should calculate IRRF with no discount and a 1900 salary")
  public void shouldCalculateIRRFWithNoDiscount() {
    IRRF sut = new IRRF();
    Empregado empregado = makeEmpregado(new BigDecimal("1900"));

    BigDecimal discount = sut.calculate(empregado);

    assertEquals(new BigDecimal("0.00"), discount);
  }

  @Test
  @Description("Should calculate IRRF with 7,5% discount and a 1903.99 salary")
  public void shouldCalculateIRRFWithSevenAndHalfPercent() {
    IRRF sut = new IRRF();
    Empregado empregado = makeEmpregado(new BigDecimal("1903.99"));

    BigDecimal discount = sut.calculate(empregado);

    assertEquals(new BigDecimal("142.79"), discount);
  }

  @Test
  @Description("Should calculate IRRF with 7,5% discount and a 2826.65 salary")
  public void shouldCalculateIRRFWithSevenAndHalfPercent_Case2() {
    IRRF sut = new IRRF();
    Empregado empregado = makeEmpregado(new BigDecimal("2826.65"));

    BigDecimal discount = sut.calculate(empregado);

    assertEquals(new BigDecimal("211.99"), discount);
  }

  @Test
  @Description("Should calculate IRRF with 15% discount and a 2826.66 salary")
  public void shouldCalculateIRRFWithFifteenPercent() {
    IRRF sut = new IRRF();
    Empregado empregado = makeEmpregado(new BigDecimal("2826.66"));

    BigDecimal discount = sut.calculate(empregado);

    assertEquals(new BigDecimal("423.99"), discount);
  }

  @Test
  @Description("Should calculate IRRF with 15% discount and a 3751.05 salary")
  public void shouldCalculateIRRFWithFifteenPercent_Case2() {
    IRRF sut = new IRRF();
    Empregado empregado = makeEmpregado(new BigDecimal("3751.05"));

    BigDecimal discount = sut.calculate(empregado);

    assertEquals(new BigDecimal("562.65"), discount);
  }

}
