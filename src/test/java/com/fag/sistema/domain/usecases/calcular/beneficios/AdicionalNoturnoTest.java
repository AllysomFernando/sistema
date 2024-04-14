package com.fag.sistema.domain.usecases.calcular.beneficios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import com.fag.sistema.domain.entities.empregado.Contrato;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empregado.Horario;
import com.fag.sistema.domain.entities.empregado.Salario;

public class AdicionalNoturnoTest {
  private Empregado makeEmpregado(BigDecimal salarioBruto, Float horasAdicionalNoturno) {
    Empregado empregado = new Empregado();
    Contrato contrato = new Contrato();

    Salario salario = new Salario();
    salario.setBase(salarioBruto);

    Horario horario = new Horario();
    horario.setHorasAdicionalNoturno(horasAdicionalNoturno);
    horario.setHoraTrabalhada(220);

    empregado.setContrato(contrato);
    contrato.setSalario(salario);
    empregado.setHorario(horario);

    return empregado;
  }

  @Test
  @Description("Should add adicional noturno if horario de trabalho is noturno")
  void shouldAddAdicionaNoturno() {
    AdicionalNoturno sut = new AdicionalNoturno();
    Empregado empregado = makeEmpregado(new BigDecimal("1900.0"), 10.0f);

    BigDecimal beneficio = sut.calculate(empregado);

    assertEquals(new BigDecimal("12.90"), beneficio);
  }

  @Test
  @Description("Should not add adicional noturno if horario de trabalho is not noturno")
  void shouldNotAddAdicionaNoturno() {
    AdicionalNoturno sut = new AdicionalNoturno();
    Empregado empregado = makeEmpregado(new BigDecimal("1900.0"), 0.0f);

    BigDecimal beneficio = sut.calculate(empregado);

    assertEquals(BigDecimal.ZERO, beneficio);
  }
}
