package com.fag.sistema.domain.usecases.calcular.descontos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import com.fag.sistema.domain.entities.empregado.Contrato;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empregado.Salario;

public class ValeAlimentacaoTest {

  private Empregado makeEmpregadoComSalario(BigDecimal salarioBruto) {
    Empregado empregado = new Empregado();
    empregado.setContrato(new Contrato());
    empregado.getContrato().setSalario(new Salario(salarioBruto));

    return empregado;
  }

  @Test
  @Description("Should calculate Vale Alimentação")
  public void shouldCalculateValeAlimentacao_Case1() {
    ValeAlimentacao sut = new ValeAlimentacao();
    Empregado empregado = makeEmpregadoComSalario(new BigDecimal("3000.00"));

    BigDecimal discount = sut.calculate(empregado);

    assertEquals(new BigDecimal("300.00"), discount);
  }

  @Test
  @Description("Should calculate Vale Alimentação")
  public void shouldCalculateValeAlimentacao_Case2() {
    ValeAlimentacao sut = new ValeAlimentacao();
    Empregado empregado = makeEmpregadoComSalario(new BigDecimal("4000.00"));

    BigDecimal discount = sut.calculate(empregado);

    assertEquals(new BigDecimal("400.00"), discount);
  }
}
