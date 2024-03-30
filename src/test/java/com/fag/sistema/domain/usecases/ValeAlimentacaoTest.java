package com.fag.sistema.domain.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import com.fag.sistema.domain.entities.Contrato;
import com.fag.sistema.domain.entities.Empregado;
import com.fag.sistema.domain.entities.Salario;
import com.fag.sistema.domain.usecases.calcular.descontos.ValeAlimentacao;

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
    Empregado empregado = makeEmpregadoComSalario(new BigDecimal("1900.00"));

    BigDecimal discount = sut.calculate(empregado);

    assertEquals(new BigDecimal("285.00"), discount);
  }

  @Test
  @Description("Should calculate Vale Alimentação")
  public void shouldCalculateValeAlimentacao_Case2() {
    ValeAlimentacao sut = new ValeAlimentacao();
    Empregado empregado = makeEmpregadoComSalario(new BigDecimal("4000.00"));

    BigDecimal discount = sut.calculate(empregado);

    assertEquals(new BigDecimal("600.00"), discount);
  }
}
