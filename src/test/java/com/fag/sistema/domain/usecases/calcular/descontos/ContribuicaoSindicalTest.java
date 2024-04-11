package com.fag.sistema.domain.usecases.calcular.descontos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import com.fag.sistema.domain.entities.Contrato;
import com.fag.sistema.domain.entities.Empregado;
import com.fag.sistema.domain.entities.Salario;

public class ContribuicaoSindicalTest {

  private Empregado makeEmpregadoComSalario(BigDecimal salarioBruto) {
    Empregado empregado = new Empregado();
    empregado.setContrato(new Contrato());
    empregado.getContrato().setSalario(new Salario(salarioBruto));

    return empregado;
  }

  @Test
  @Description("Should calculate Contribuicao Sindical")
  public void shouldCalculateContribuicaoSindical() {
    ContribuicaoSindical sut = new ContribuicaoSindical();
    Empregado empregado = makeEmpregadoComSalario(new BigDecimal("1900.00"));

    BigDecimal discount = sut.calculate(empregado);

    assertEquals(new BigDecimal("50.00"), discount);
  }
}
