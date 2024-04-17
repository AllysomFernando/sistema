package com.fag.sistema.domain.usecases.calcular.beneficios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import com.fag.sistema.domain.entities.empregado.Beneficios;
import com.fag.sistema.domain.entities.empregado.Contrato;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empregado.Salario;
import com.fag.sistema.domain.entities.empresa.Empresa;
import com.fag.sistema.domain.enums.EnumGrauInsalubridade;

public class AdicionalPericulosidadeTest {
  private Empregado makeEmpregado(BigDecimal salarioBruto) {
    Empregado empregado = new Empregado();
    Contrato contrato = new Contrato();
    Salario salario = new Salario(salarioBruto);
    Beneficios beneficios = new Beneficios(false, false, false, true);

    contrato.setSalario(salario);
    contrato.setBeneficios(beneficios);

    empregado.setContrato(contrato);

    return empregado;
  }

  private Empresa makeEmpresa() {
    Empresa empresa = new Empresa();

    return empresa;
  }

  @Test
  @Description("Should update base de calculos")
  public void shouldUpdateBaseDeCalculos() {
    AdicionalPericulosidade sut = new AdicionalPericulosidade();
    Empregado empregado = makeEmpregado(new BigDecimal("2000"));
    Empresa empresa = makeEmpresa();

    sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("2060.00"), empregado.getContrato().getSalario().getBaseCalculoInss());
    assertEquals(new BigDecimal("2060.00"), empregado.getContrato().getSalario().getBaseCalculoFGTS());
    assertEquals(new BigDecimal("2060.00"), empregado.getContrato().getSalario().getBaseCalculoIRRF());
  }

  @Test
  void shouldAddAdicionalPericulosidade() {
    AdicionalPericulosidade sut = new AdicionalPericulosidade();
    Empregado empregado = makeEmpregado(new BigDecimal("1900.0"));
    Empresa empregador = makeEmpresa();

    BigDecimal beneficio = sut.calculate(empregado, empregador);

    assertEquals(new BigDecimal("57.00"), beneficio);
  }

  @Test
  void shouldAddAdicionalPericulosidade_Case2() {
    AdicionalPericulosidade sut = new AdicionalPericulosidade();
    Empregado empregado = makeEmpregado(new BigDecimal("2000.0"));
    Empresa empregador = makeEmpresa();

    BigDecimal beneficio = sut.calculate(empregado, empregador);

    assertEquals(new BigDecimal("60.00"), beneficio);
  }

  @Test
  @Description("Should not add Adicional Periculosidade if has grau insalubridade")
  void shouldNotAddAdicionalPericulosidade() {
    AdicionalPericulosidade sut = new AdicionalPericulosidade();
    Empregado empregado = makeEmpregado(new BigDecimal("1900.0"));
    empregado.getContrato().setGrauInsalubridade(EnumGrauInsalubridade.BAIXO);
    Empresa empregador = makeEmpresa();

    BigDecimal beneficio = sut.calculate(empregado, empregador);

    assertEquals(BigDecimal.ZERO, beneficio);
  }
}
