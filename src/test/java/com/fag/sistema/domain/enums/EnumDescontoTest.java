package com.fag.sistema.domain.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

public class EnumDescontoTest {

  @Test
  @Description("Should calculate Contribuicao Sindical")
  public void shouldCalculateContribuicaoSindical() {
    EnumDesconto enumDesconto = EnumDesconto.CONTRIBUICAO_SINDICAL;
    BigDecimal salarioBruto = new BigDecimal("1900");

    Float discount = enumDesconto.calculate(salarioBruto);

    assertEquals(50f, discount);
  }

  @Test
  @Description("Should calculate Vale Alimentação")
  public void shouldCalculateValeAlimentacao_Case1() {
    EnumDesconto enumDesconto = EnumDesconto.VALE_ALIMENTACAO;
    BigDecimal salarioBruto = new BigDecimal("1900");

    Float discount = enumDesconto.calculate(salarioBruto);

    assertEquals(285f, discount);
  }

  @Test
  @Description("Should calculate Vale Alimentação")
  public void shouldCalculateValeAlimentacao_Case2() {
    EnumDesconto enumDesconto = EnumDesconto.VALE_ALIMENTACAO;
    BigDecimal salarioBruto = new BigDecimal("4000");

    Float discount = enumDesconto.calculate(salarioBruto);

    assertEquals(600f, discount);
  }

  @Test
  @Description("Should calculate INSS with 8% discount and a 1600 salary")
  public void shouldCalculateINSSWithEightPercent() {
    EnumDesconto enumDesconto = EnumDesconto.INSS;
    BigDecimal salarioBruto = new BigDecimal("1600");

    Float discount = enumDesconto.calculate(salarioBruto);

    assertEquals(128.0f, discount);
  }

  @Test
  @Description("Should calculate INSS with 8% discount and a 1751.81 salary")
  public void shouldCalculateINSSWithEightPercent_Case2() {
    EnumDesconto enumDesconto = EnumDesconto.INSS;
    BigDecimal salarioBruto = new BigDecimal("1751.81");

    Float discount = enumDesconto.calculate(salarioBruto);

    assertEquals(140.14f, discount);
  }

  @Test
  @Description("Should calculate INSS with 9% discount and a 1800 salary")
  public void shouldCalculateINSSWithNinePercent() {
    EnumDesconto enumDesconto = EnumDesconto.INSS;
    BigDecimal salarioBruto = new BigDecimal("1800");

    Float discount = enumDesconto.calculate(salarioBruto);

    assertEquals(162.0f, discount);
  }

  @Test
  @Description("Should calculate INSS with 9% discount and a 1751.82 salary")
  public void shouldCalculateINSSWithNinePercent_Case2() {
    EnumDesconto enumDesconto = EnumDesconto.INSS;
    BigDecimal salarioBruto = new BigDecimal("1751.82");

    Float discount = enumDesconto.calculate(salarioBruto);

    assertEquals(157.66f, discount);
  }

  @Test
  @Description("Should calculate INSS with 9% discount and a 2919.72 salary")
  public void shouldCalculateINSSWithNinePercent_Case3() {
    EnumDesconto enumDesconto = EnumDesconto.INSS;
    BigDecimal salarioBruto = new BigDecimal("2919.72");

    Float discount = enumDesconto.calculate(salarioBruto);

    assertEquals(262.77f, discount);
  }

  @Test
  @Description("Should calculate INSS with 11% discount and a 4000 salary")
  public void shouldCalculateINSSWithElevenPercent() {
    EnumDesconto enumDesconto = EnumDesconto.INSS;
    BigDecimal salarioBruto = new BigDecimal("4000");

    Float discount = enumDesconto.calculate(salarioBruto);

    assertEquals(440.0f, discount);
  }

  @Test
  @Description("Should calculate INSS with 11% discount and a 2919.73 salary")
  public void shouldCalculateINSSWithElevenPercent_Case2() {
    EnumDesconto enumDesconto = EnumDesconto.INSS;
    BigDecimal salarioBruto = new BigDecimal("2919.73");

    Float discount = enumDesconto.calculate(salarioBruto);

    assertEquals(321.17f, discount);
  }

  @Test
  @Description("Should calculate INSS with 11% discount and a 5839.45 salary")
  public void shouldCalculateINSSWithElevenPercent_Case3() {
    EnumDesconto enumDesconto = EnumDesconto.INSS;
    BigDecimal salarioBruto = new BigDecimal("5839.45");

    Float discount = enumDesconto.calculate(salarioBruto);

    assertEquals(642.33f, discount);
  }

  @Test
  @Description("Should calculate INSS with salary above R$ 5.839,45")
  public void shouldCalculateINSSWithFixedDiscountValue() {
    EnumDesconto enumDesconto = EnumDesconto.INSS;
    BigDecimal salarioBruto = new BigDecimal("6000.0");

    Float discount = enumDesconto.calculate(salarioBruto);

    assertEquals(642.34f, discount);
  }

  @Test
  public void shouldCalculateFGTSIfSalaryIsThreeThousand() {
    EnumDesconto enumDesconto = EnumDesconto.FGTS;
    BigDecimal salarioBruto = new BigDecimal("3000");

    Float discount = enumDesconto.calculate(salarioBruto);

    assertEquals(240.0f, discount);
  }

  @Test
  @Description("Should calculate IRRF with no discount and a 1900 salary")
  public void shouldCalculateIRRFWithNoDiscount() {
    EnumDesconto enumDesconto = EnumDesconto.IRRF;
    BigDecimal salarioBruto = new BigDecimal("1900");

    Float discount = enumDesconto.calculate(salarioBruto);

    assertEquals(0f, discount);
  }

  @Test
  @Description("Should calculate IRRF with 7,5% discount and a 1903.99 salary")
  public void shouldCalculateIRRFWithSevenAndHalfPercent() {
    EnumDesconto enumDesconto = EnumDesconto.IRRF;
    BigDecimal salarioBruto = new BigDecimal("1903.99");

    Float discount = enumDesconto.calculate(salarioBruto);

    assertEquals(142.79f, discount);
  }

}
