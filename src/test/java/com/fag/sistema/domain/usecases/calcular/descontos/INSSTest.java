package com.fag.sistema.domain.usecases.calcular.descontos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import com.fag.sistema.domain.entities.empregado.Contrato;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empregado.Salario;

public class INSSTest {

  private Empregado makeEmpregadoComSalario(BigDecimal salarioBruto) {
    Empregado empregado = new Empregado();
    empregado.setContrato(new Contrato());
    empregado.getContrato().setSalario(new Salario(salarioBruto));

    return empregado;
  }

  @Test
  @Description("Should calculate INSS with 8% discount and a 1600 salary")
  public void shouldCalculateINSSWithEightPercent() {
    INSS sut = new INSS();

    Empregado empregado = makeEmpregadoComSalario(new BigDecimal("1600.00"));

    BigDecimal discount = sut.calculate(empregado);

    assertEquals(new BigDecimal("128.00"), discount);
  }

  @Test
  @Description("Should calculate INSS with 8% discount and a 1751.81 salary")
  public void shouldCalculateINSSWithEightPercent_Case2() {
    INSS sut = new INSS();

    Empregado empregado = makeEmpregadoComSalario(new BigDecimal("1751.81"));

    BigDecimal discount = sut.calculate(empregado);

    assertEquals(new BigDecimal("140.14"), discount);
  }

  @Test
  @Description("Should calculate INSS with 9% discount and a 1800 salary")
  public void shouldCalculateINSSWithNinePercent() {
    INSS sut = new INSS();

    Empregado empregado = makeEmpregadoComSalario(new BigDecimal("1800.00"));

    BigDecimal discount = sut.calculate(empregado);

    assertEquals(new BigDecimal("162.00"), discount);
  }

  @Test
  @Description("Should calculate INSS with 9% discount and a 1751.82 salary")
  public void shouldCalculateINSSWithNinePercent_Case2() {
    INSS sut = new INSS();

    Empregado empregado = makeEmpregadoComSalario(new BigDecimal("1751.82"));

    BigDecimal discount = sut.calculate(empregado);

    assertEquals(new BigDecimal("157.66"), discount);
  }

  @Test
  @Description("Should calculate INSS with 9% discount and a 2919.72 salary")
  public void shouldCalculateINSSWithNinePercent_Case3() {
    INSS sut = new INSS();

    Empregado empregado = makeEmpregadoComSalario(new BigDecimal("2919.72"));

    BigDecimal discount = sut.calculate(empregado);

    assertEquals(new BigDecimal("262.77"), discount);
  }

  @Test
  @Description("Should calculate INSS with 11% discount and a 4000 salary")
  public void shouldCalculateINSSWithElevenPercent() {
    INSS sut = new INSS();

    Empregado empregado = makeEmpregadoComSalario(new BigDecimal("4000.00"));

    BigDecimal discount = sut.calculate(empregado);

    assertEquals(new BigDecimal("440.00"), discount);
  }

  @Test
  @Description("Should calculate INSS with 11% discount and a 2919.73 salary")
  public void shouldCalculateINSSWithElevenPercent_Case2() {
    INSS sut = new INSS();

    Empregado empregado = makeEmpregadoComSalario(new BigDecimal("2919.73"));

    BigDecimal discount = sut.calculate(empregado);

    assertEquals(new BigDecimal("321.17"), discount);
  }

  @Test
  @Description("Should calculate INSS with 11% discount and a 5839.45 salary")
  public void shouldCalculateINSSWithElevenPercent_Case3() {
    INSS sut = new INSS();

    Empregado empregado = makeEmpregadoComSalario(new BigDecimal("5839.45"));

    BigDecimal discount = sut.calculate(empregado);

    assertEquals(new BigDecimal("642.33"), discount);
  }

  @Test
  @Description("Should calculate INSS with salary above R$ 5.839,45")
  public void shouldCalculateINSSWithFixedDiscountValue() {
    INSS sut = new INSS();

    Empregado empregado = makeEmpregadoComSalario(new BigDecimal("6000.00"));

    BigDecimal discount = sut.calculate(empregado);

    assertEquals(new BigDecimal("642.34"), discount);
  }
}
