package com.fag.sistema.domain.usecases.calcular.beneficios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import com.fag.sistema.domain.entities.Contrato;
import com.fag.sistema.domain.entities.Empregado;
import com.fag.sistema.domain.entities.Salario;

public class AdicionalInsalubridadeTest {
  private Empregado makeEmpregadoComSalarioEGrauDeInsalubridade(BigDecimal salarioBruto, Integer grauInsalubridade) {
    Empregado empregado = new Empregado();
    empregado.setContrato(new Contrato());
    empregado.getContrato().setSalario(new Salario(salarioBruto));
    empregado.getContrato().setGrauInsalubridade(grauInsalubridade);

    return empregado;
  }

  @Test
  @Description("Should calculate Adicional Insalubridade with grau 10")
  public void shouldCalculateAdicionalInsalubridade() {
    AdicionalInsalubridade sut = new AdicionalInsalubridade();
    Empregado empregado = makeEmpregadoComSalarioEGrauDeInsalubridade(new BigDecimal("1900.0"), 10);

    BigDecimal beneficio = sut.calculate(empregado);

    assertEquals(new BigDecimal("190.00"), beneficio);
  }
}
