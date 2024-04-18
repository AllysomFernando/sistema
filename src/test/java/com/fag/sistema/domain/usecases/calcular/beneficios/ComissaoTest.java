package com.fag.sistema.domain.usecases.calcular.beneficios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.fag.sistema.domain.entities.empregado.Contrato;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empregado.Salario;
import com.fag.sistema.domain.entities.empresa.Empresa;

public class ComissaoTest {
  private Empregado makeEmpregado(BigDecimal salarioBruto, BigDecimal valorDeVendasMensal) {
    Empregado empregado = new Empregado();
    Contrato contrato = new Contrato();
    Salario salario = new Salario(salarioBruto);

    contrato.setSalario(salario);

    empregado.setContrato(contrato);
    empregado.setTotalDeVendasNoMes(valorDeVendasMensal);

    return empregado;
  }

  private Empresa makeEmpresa() {
    Empresa empresa = new Empresa();

    return empresa;
  }

  @Test
  public void shouldUpdateBaseDeCalculos() {
    Comissao sut = new Comissao();
    Empregado empregado = makeEmpregado(new BigDecimal("2000"), new BigDecimal("1400"));
    Empresa empresa = makeEmpresa();

    sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("2084.00"), empregado.getContrato().getSalario().getBaseCalculoInss());
    assertEquals(new BigDecimal("2084.00"), empregado.getContrato().getSalario().getBaseCalculoFGTS());
    assertEquals(new BigDecimal("2084.00"), empregado.getContrato().getSalario().getBaseCalculoIRRF());
  }

  @Test
  void shouldReturnValueIfComissaoIsNotNull() {
    Comissao sut = new Comissao();
    Empregado empregado = makeEmpregado(new BigDecimal("2000"), new BigDecimal("1400"));
    Empresa empresa = makeEmpresa();

    BigDecimal comissao = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("84.00"), comissao);
  }

  @Test
  void shouldReturnZeroIfComissaoNull() {
    Comissao sut = new Comissao();
    Empregado empregado = makeEmpregado(new BigDecimal("2000"), BigDecimal.ZERO);
    Empresa empresa = makeEmpresa();

    BigDecimal comissao = sut.calculate(empregado, empresa);

    assertEquals(BigDecimal.ZERO, comissao);
  }
}
