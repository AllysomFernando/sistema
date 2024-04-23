package com.fag.sistema.domain.usecases.calcular.beneficios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import com.fag.sistema.domain.entities.empregado.Contrato;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empregado.Horario;
import com.fag.sistema.domain.entities.empregado.Salario;
import com.fag.sistema.domain.entities.empresa.Empresa;

public class AdicionalNoturnoTest {
  private Empregado makeEmpregado(BigDecimal salarioBruto, Float horasAdicionalNoturno) {
    Empregado empregado = new Empregado();
    Contrato contrato = new Contrato();

    Salario salario = new Salario(salarioBruto);

    Horario horario = new Horario();
    horario.setHorasAdicionalNoturno(horasAdicionalNoturno);

    contrato.setSalario(salario);

    empregado.setContrato(contrato);
    empregado.setHorario(horario);

    return empregado;
  }

  private Empresa makeEmpresa() {
    Empresa empresa = new Empresa();
    empresa.setCargaHorariaMensal(220F);

    return empresa;
  }

  @Test
  @Description("Should update base de calculos")
  public void shouldUpdateBaseDeCalculos() {
    AdicionalNoturno sut = new AdicionalNoturno();
    Empregado empregado = makeEmpregado(new BigDecimal("2000"), 10.0f);
    Empresa empresa = makeEmpresa();

    sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("2136.35"), empregado.getContrato().getSalario().getBaseCalculoInss());
    assertEquals(new BigDecimal("2136.35"), empregado.getContrato().getSalario().getBaseCalculoFGTS());
    assertEquals(new BigDecimal("2136.35"), empregado.getContrato().getSalario().getBaseCalculoIRRF());
  }

  @Test
  @Description("Should add adicional noturno if horario de trabalho is noturno")
  void shouldAddAdicionaNoturno() {
    AdicionalNoturno sut = new AdicionalNoturno();
    Empregado empregado = makeEmpregado(new BigDecimal("1900.0"), 10.0f);
    Empresa empresa = makeEmpresa();

    BigDecimal beneficio = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("129.60"), beneficio);
  }

  @Test
  @Description("Should not add adicional noturno if horario de trabalho is not noturno")
  void shouldNotAddAdicionaNoturno() {
    AdicionalNoturno sut = new AdicionalNoturno();
    Empregado empregado = makeEmpregado(new BigDecimal("1900.0"), 0.0f);

    Empresa empresa = makeEmpresa();

    BigDecimal beneficio = sut.calculate(empregado, empresa);

    assertEquals(BigDecimal.ZERO, beneficio);
  }
}
