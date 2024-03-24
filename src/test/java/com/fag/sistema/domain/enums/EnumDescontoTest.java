package com.fag.sistema.domain.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

public class EnumDescontoTest {
  
  @Test
  @Description("Shoul calculate INSS with 8% discount")
  public void shouldCalculateINSSWithEightPorcent() {
    EnumDesconto enumDesconto = EnumDesconto.INSS;
    BigDecimal salarioBruto = new BigDecimal(1600);
    Float inss = enumDesconto.calculate(salarioBruto);

    assertEquals(128.0f, inss);
  }

  @Test
  @Description("Shoul calculate INSS with 9% discount")
  public void shouldCalculateINSSWithNinePorcent() {
    EnumDesconto enumDesconto = EnumDesconto.INSS;
    BigDecimal salarioBruto = new BigDecimal(1800);
    Float inss = enumDesconto.calculate(salarioBruto);

    assertEquals(162.0f, inss);
  }

  @Test
  @Description("Shoul calculate INSS with 11% discount")
  public void shouldCalculateINSSWithElevenPorcent() {
    EnumDesconto enumDesconto = EnumDesconto.INSS;
    BigDecimal salarioBruto = new BigDecimal(3000);
    Float inss = enumDesconto.calculate(salarioBruto);

    assertEquals(330.0f, inss);
  }

  @Test
  public void shouldCalculateFGTSIfSalaryIsThreeThousand() {
    EnumDesconto enumDesconto = EnumDesconto.FGTS;
    BigDecimal salarioBruto = new BigDecimal(3000);
    Float inss = enumDesconto.calculate(salarioBruto);

    assertEquals(240.0f, inss);
  }
}
