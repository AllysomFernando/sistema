package com.fag.sistema.domain.usecases.calcular.descontos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import com.fag.sistema.domain.entities.empregado.Contrato;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empregado.Salario;
import com.fag.sistema.domain.entities.empresa.Empregador;

public class INSSTest {

  private Empregado makeEmpregado(BigDecimal salarioBruto) {
    Empregado empregado = new Empregado();
    Contrato contrato = new Contrato();
    Salario salario = new Salario(salarioBruto);
    contrato.setSalario(salario);
    empregado.setContrato(contrato);

    return empregado;
  }

  private Empregador makeEmpresa() {
    Empregador empresa = new Empregador();

    return empresa;
  }

  @Test
  @Description("Should calculate INSS with 8% discount and a 1600 salary")
  public void shouldCalculateINSSWithEightPercent() {
    INSS sut = new INSS();

    Empregado empregado = makeEmpregado(new BigDecimal("1600"));
    Empregador empresa = makeEmpresa();

    BigDecimal discount = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("128.00"), discount);
    assertEquals(8.0f, sut.getReferencia());
    assertEquals(discount, sut.getDesconto());
  }

  @Test
  @Description("Should calculate INSS with 8% discount and a 1751.81 salary")
  public void shouldCalculateINSSWithEightPercent_Case2() {
    INSS sut = new INSS();
    Empregado empregado = makeEmpregado(new BigDecimal("1751.81"));
    Empregador empresa = makeEmpresa();

    BigDecimal discount = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("140.14"), discount);
    assertEquals(8.0f, sut.getReferencia());
    assertEquals(discount, sut.getDesconto());
  }

  @Test
  @Description("Should calculate INSS with 9% discount and a 1800 salary")
  public void shouldCalculateINSSWithNinePercent() {
    INSS sut = new INSS();
    Empregado empregado = makeEmpregado(new BigDecimal("1800.00"));
    Empregador empresa = makeEmpresa();

    BigDecimal discount = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("162.00"), discount);
    assertEquals(9.0f, sut.getReferencia());
    assertEquals(discount, sut.getDesconto());
  }

  @Test
  @Description("Should calculate INSS with 9% discount and a 1751.82 salary")
  public void shouldCalculateINSSWithNinePercent_Case2() {
    INSS sut = new INSS();
    Empregado empregado = makeEmpregado(new BigDecimal("1751.82"));
    Empregador empresa = makeEmpresa();

    BigDecimal discount = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("157.66"), discount);
    assertEquals(9.0f, sut.getReferencia());
    assertEquals(discount, sut.getDesconto());
  }

  @Test
  @Description("Should calculate INSS with 9% discount and a 2919.72 salary")
  public void shouldCalculateINSSWithNinePercent_Case3() {
    INSS sut = new INSS();
    Empregado empregado = makeEmpregado(new BigDecimal("2919.72"));
    Empregador empresa = makeEmpresa();
    BigDecimal discount = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("262.77"), discount);
    assertEquals(9.0f, sut.getReferencia());
    assertEquals(discount, sut.getDesconto());
  }

  @Test
  @Description("Should calculate INSS with 11% discount and a 4000 salary")
  public void shouldCalculateINSSWithElevenPercent() {
    INSS sut = new INSS();
    Empregado empregado = makeEmpregado(new BigDecimal("4000.00"));
    Empregador empresa = makeEmpresa();
    BigDecimal discount = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("440.00"), discount);
    assertEquals(11.0f, sut.getReferencia());
    assertEquals(discount, sut.getDesconto());
  }

  @Test
  @Description("Should calculate INSS with 11% discount and a 2919.73 salary")
  public void shouldCalculateINSSWithElevenPercent_Case2() {
    INSS sut = new INSS();
    Empregado empregado = makeEmpregado(new BigDecimal("2919.73"));
    Empregador empresa = makeEmpresa();
    BigDecimal discount = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("321.17"), discount);
    assertEquals(11.0f, sut.getReferencia());
    assertEquals(discount, sut.getDesconto());
  }

  @Test
  @Description("Should calculate INSS with 11% discount and a 5839.45 salary")
  public void shouldCalculateINSSWithElevenPercent_Case3() {
    INSS sut = new INSS();
    Empregado empregado = makeEmpregado(new BigDecimal("5839.45"));
    Empregador empresa = makeEmpresa();
    BigDecimal discount = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("642.34"), discount);
    assertEquals(11.0f, sut.getReferencia());
    assertEquals(discount, sut.getDesconto());
  }

  @Test
  @Description("Should calculate INSS with salary above R$ 5.839,45")
  public void shouldCalculateINSSWithFixedDiscountValue() {
    INSS sut = new INSS();
    Empregado empregado = makeEmpregado(new BigDecimal("6000.00"));
    Empregador empresa = makeEmpresa();
    BigDecimal discount = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("642.34"), discount);
    assertEquals(0.0f, sut.getReferencia());
    assertEquals(discount, sut.getDesconto());
  }
}
