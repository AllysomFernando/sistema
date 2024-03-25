package com.fag.sistema.domain.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

public class EnumDescontoTest {

  @Test
  @Description("Should calculate Contribuicao Sindical")
  public void shouldCalculateContribuicaoSindical() {
    EnumDesconto enumDesconto = EnumDesconto.CONTRIBUICAO_SINDICAL;
    BigDecimal salarioBruto = new BigDecimal("1900");

    BigDecimal discount = enumDesconto.calculate(salarioBruto);

    assertEquals(new BigDecimal("50.00"), discount);
  }

  @Test
  @Description("Should calculate Vale Alimentação")
  public void shouldCalculateValeAlimentacao_Case1() {
    EnumDesconto enumDesconto = EnumDesconto.VALE_ALIMENTACAO;
    BigDecimal salarioBruto = new BigDecimal("1900");

    BigDecimal discount = enumDesconto.calculate(salarioBruto);

    assertEquals(new BigDecimal("285.00"), discount);
  }

  @Test
  @Description("Should calculate Vale Alimentação")
  public void shouldCalculateValeAlimentacao_Case2() {
    EnumDesconto enumDesconto = EnumDesconto.VALE_ALIMENTACAO;
    BigDecimal salarioBruto = new BigDecimal("4000");

    BigDecimal discount = enumDesconto.calculate(salarioBruto);

    assertEquals(new BigDecimal("600.00"), discount);
  }

  @Test
  @Description("Should calculate 3% discount from Vale Transporte")
  public void shouldCalculateValeTransporte() {
    EnumDesconto enumDesconto = EnumDesconto.VALE_TRANSPORTE;
    BigDecimal salarioBruto = new BigDecimal("3000");

    BigDecimal discount = enumDesconto.calculate(salarioBruto);

    assertEquals(new BigDecimal("90.00"), discount);
  }

  @Test
  @Description("Should calculate INSS with 8% discount and a 1600 salary")
  public void shouldCalculateINSSWithEightPercent() {
    EnumDesconto enumDesconto = EnumDesconto.INSS;
    BigDecimal salarioBruto = new BigDecimal("1600");

    BigDecimal discount = enumDesconto.calculate(salarioBruto);

    assertEquals(new BigDecimal("128.00"), discount);
  }

  @Test
  @Description("Should calculate INSS with 8% discount and a 1751.81 salary")
  public void shouldCalculateINSSWithEightPercent_Case2() {
    EnumDesconto enumDesconto = EnumDesconto.INSS;
    BigDecimal salarioBruto = new BigDecimal("1751.81");

    BigDecimal discount = enumDesconto.calculate(salarioBruto);

    assertEquals(new BigDecimal("140.14"), discount);
  }

  @Test
  @Description("Should calculate INSS with 9% discount and a 1800 salary")
  public void shouldCalculateINSSWithNinePercent() {
    EnumDesconto enumDesconto = EnumDesconto.INSS;
    BigDecimal salarioBruto = new BigDecimal("1800");

    BigDecimal discount = enumDesconto.calculate(salarioBruto);

    assertEquals(new BigDecimal("162.00"), discount);
  }

  @Test
  @Description("Should calculate INSS with 9% discount and a 1751.82 salary")
  public void shouldCalculateINSSWithNinePercent_Case2() {
    EnumDesconto enumDesconto = EnumDesconto.INSS;
    BigDecimal salarioBruto = new BigDecimal("1751.82");

    BigDecimal discount = enumDesconto.calculate(salarioBruto);

    assertEquals(new BigDecimal("157.66"), discount);
  }

  @Test
  @Description("Should calculate INSS with 9% discount and a 2919.72 salary")
  public void shouldCalculateINSSWithNinePercent_Case3() {
    EnumDesconto enumDesconto = EnumDesconto.INSS;
    BigDecimal salarioBruto = new BigDecimal("2919.72");

    BigDecimal discount = enumDesconto.calculate(salarioBruto);

    assertEquals(new BigDecimal("262.77"), discount);
  }

  @Test
  @Description("Should calculate INSS with 11% discount and a 4000 salary")
  public void shouldCalculateINSSWithElevenPercent() {
    EnumDesconto enumDesconto = EnumDesconto.INSS;
    BigDecimal salarioBruto = new BigDecimal("4000");

    BigDecimal discount = enumDesconto.calculate(salarioBruto);

    assertEquals(new BigDecimal("440.00"), discount);
  }

  @Test
  @Description("Should calculate INSS with 11% discount and a 2919.73 salary")
  public void shouldCalculateINSSWithElevenPercent_Case2() {
    EnumDesconto enumDesconto = EnumDesconto.INSS;
    BigDecimal salarioBruto = new BigDecimal("2919.73");

    BigDecimal discount = enumDesconto.calculate(salarioBruto);

    assertEquals(new BigDecimal("321.17"), discount);
  }

  @Test
  @Description("Should calculate INSS with 11% discount and a 5839.45 salary")
  public void shouldCalculateINSSWithElevenPercent_Case3() {
    EnumDesconto enumDesconto = EnumDesconto.INSS;
    BigDecimal salarioBruto = new BigDecimal("5839.45");

    BigDecimal discount = enumDesconto.calculate(salarioBruto);

    assertEquals(new BigDecimal("642.33"), discount);
  }

  @Test
  @Description("Should calculate INSS with salary above R$ 5.839,45")
  public void shouldCalculateINSSWithFixedDiscountValue() {
    EnumDesconto enumDesconto = EnumDesconto.INSS;
    BigDecimal salarioBruto = new BigDecimal("6000.0");

    BigDecimal discount = enumDesconto.calculate(salarioBruto);

    assertEquals(new BigDecimal("642.34"), discount);
  }

  @Test
  public void shouldCalculateFGTSIfSalaryIsThreeThousand() {
    EnumDesconto enumDesconto = EnumDesconto.FGTS;
    BigDecimal salarioBruto = new BigDecimal("3000");

    BigDecimal discount = enumDesconto.calculate(salarioBruto);

    assertEquals(new BigDecimal("240.00"), discount);
  }

  @Test
  @Description("Should calculate IRRF with no discount and a 1900 salary")
  public void shouldCalculateIRRFWithNoDiscount() {
    EnumDesconto enumDesconto = EnumDesconto.IRRF;
    BigDecimal salarioBruto = new BigDecimal("1900");

    BigDecimal discount = enumDesconto.calculate(salarioBruto);

    assertEquals(new BigDecimal("0.00"), discount);
  }

  @Test
  @Description("Should calculate IRRF with 7,5% discount and a 1903.99 salary")
  public void shouldCalculateIRRFWithSevenAndHalfPercent() {
    EnumDesconto enumDesconto = EnumDesconto.IRRF;
    BigDecimal salarioBruto = new BigDecimal("1903.99");

    BigDecimal discount = enumDesconto.calculate(salarioBruto);

    assertEquals(new BigDecimal("142.79"), discount);
  }

  @Test
  @Description("Should calculate IRRF with 7,5% discount and a 2826.65 salary")
  public void shouldCalculateIRRFWithSevenAndHalfPercent_Case2() {
    EnumDesconto enumDesconto = EnumDesconto.IRRF;
    BigDecimal salarioBruto = new BigDecimal("2826.65");

    BigDecimal discount = enumDesconto.calculate(salarioBruto);

    assertEquals(salarioBruto.multiply(new BigDecimal("0.075")).setScale(2, RoundingMode.DOWN), discount);
  }

}
