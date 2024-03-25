package com.fag.sistema.domain.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

public class EnumDescontoTest {
  
  @Test
  @Description("Should calculate INSS with 8% discount and a 1600 salary")
  public void shouldCalculateINSSWithEightPorcent() {
    EnumDesconto enumDesconto = EnumDesconto.INSS;
    BigDecimal salarioBruto = new BigDecimal(1600);

    Float inss = enumDesconto.calculate(salarioBruto);

    assertEquals(128.0f, inss);
  }

  @Test
  @Description("Should calculate INSS with 9% discount and a 1800 salary")
  public void shouldCalculateINSSWithNinePorcent() {
    EnumDesconto enumDesconto = EnumDesconto.INSS;
    BigDecimal salarioBruto = new BigDecimal(1800);
    Float inss = enumDesconto.calculate(salarioBruto);

    assertEquals(162.0f, inss);
  }

  @Test
  @Description("Should calculate INSS with 11% discount and a 3000 salary")
  public void shouldCalculateINSSWithElevenPorcent() {
    EnumDesconto enumDesconto = EnumDesconto.INSS;
    BigDecimal salarioBruto = new BigDecimal(3000);
    Float inss = enumDesconto.calculate(salarioBruto);

    assertEquals(330.0f, inss);
  }

  @Test
  @Description("Should calculate INSS with salary above R$ 5.839,45")
  public void shouldCalculateINSSWithFixedDiscountValue() {
    EnumDesconto enumDesconto = EnumDesconto.INSS;
    BigDecimal salarioBruto = new BigDecimal(6000.0f);

    Float inss = enumDesconto.calculate(salarioBruto);

    assertEquals(642.34f, inss);
  }

  @Test
  public void shouldCalculateFGTSIfSalaryIsThreeThousand() {
    EnumDesconto enumDesconto = EnumDesconto.FGTS;
    BigDecimal salarioBruto = new BigDecimal(3000);
    Float inss = enumDesconto.calculate(salarioBruto);

    assertEquals(240.0f, inss);
  }
}
