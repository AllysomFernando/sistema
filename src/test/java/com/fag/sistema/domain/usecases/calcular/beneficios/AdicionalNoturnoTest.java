package com.fag.sistema.domain.usecases.calcular.beneficios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.fag.sistema.domain.entities.Contrato;
import com.fag.sistema.domain.entities.Empregado;
import com.fag.sistema.domain.entities.Salario;
import com.fag.sistema.domain.enums.EnumHorarioTrabalho;

public class AdicionalNoturnoTest {
  private Empregado makeEmpregado(BigDecimal salarioBruto, EnumHorarioTrabalho horarioTrabalho) {
    Empregado empregado = new Empregado();
    empregado.setContrato(new Contrato());
    empregado.getContrato().setSalario(new Salario(salarioBruto));
    empregado.getContrato().setHorarioTrabalho(horarioTrabalho);

    return empregado;
  }

  @Test
  void shouldAddAdicionaNoturno() {
    AdicionalNoturno sut = new AdicionalNoturno();
    Empregado empregado = makeEmpregado(new BigDecimal("1900.0"), EnumHorarioTrabalho.NOTURNO);

    BigDecimal beneficio = sut.calculate(empregado);

    assertEquals(new BigDecimal("285.00"), beneficio);
  }

  @Test
  void shouldNotAddAdicionaNoturno() {
    AdicionalNoturno sut = new AdicionalNoturno();
    Empregado empregado = makeEmpregado(new BigDecimal("1900.0"), EnumHorarioTrabalho.COMERCIAL);

    BigDecimal beneficio = sut.calculate(empregado);

    assertEquals(BigDecimal.ZERO, beneficio);
  }
}
