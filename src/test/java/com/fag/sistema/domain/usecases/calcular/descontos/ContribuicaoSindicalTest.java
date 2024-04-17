package com.fag.sistema.domain.usecases.calcular.descontos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import com.fag.sistema.domain.entities.empregado.Contrato;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empregado.Salario;
import com.fag.sistema.domain.entities.empresa.Empresa;

public class ContribuicaoSindicalTest {

  private Empregado makeEmpregadoComSalario(BigDecimal salarioBruto) {
    Empregado empregado = new Empregado();
    empregado.setContrato(new Contrato());
    empregado.getContrato().setSalario(new Salario(salarioBruto));

    return empregado;
  }

  private Empresa makeEmpresa() {
    Empresa empresa = new Empresa();

    return empresa;
  }

  @Test
  @Description("Should calculate Contribuicao Sindical")
  public void shouldCalculateContribuicaoSindical() {
    ContribuicaoSindical sut = new ContribuicaoSindical();
    Empregado empregado = makeEmpregadoComSalario(new BigDecimal("1900.00"));
    Empresa empresa = makeEmpresa();

    BigDecimal discount = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("50.00"), discount);
  }
}
