package com.fag.sistema.domain.usecases.calcular.beneficios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.fag.sistema.domain.entities.empregado.Contrato;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empregado.Horario;
import com.fag.sistema.domain.entities.empregado.Salario;
import com.fag.sistema.domain.entities.empresa.Empresa;

public class HorasExtrasFimDeSemanaTest {


  private Empregado makeEmpregado(BigDecimal salarioBruto, float horasExtras) {
    Empregado empregado = new Empregado();
    Horario horario = new Horario();
    Contrato contrato = new Contrato();
    Salario salario = new Salario(salarioBruto);

    horario.setHorasExtras(horasExtras);
    contrato.setSalario(salario);
    salario.setBruto(salarioBruto);

    empregado.setContrato(contrato);
    empregado.setHorario(horario);

    return empregado;
  }

  private Empresa makeEmpresa(Float cargaHorariaMensal) {
    Empresa empresa = new Empresa();
    empresa.setDiasATrabalhar(21);
    empresa.setCargaHorariaDiaria(8f);
    empresa.setCargaHorariaMensal(cargaHorariaMensal);

    return empresa;
  }

  @Test
  void shouldReturnTheValueOfHour() {
    HorasExtrasFimDeSemana sut = new HorasExtrasFimDeSemana();
    BigDecimal salarioBruto = new BigDecimal("3000");
    Float cargaHorariaMensal = 220F;

    BigDecimal result = sut.valorHora(salarioBruto, cargaHorariaMensal);

    assertEquals(new BigDecimal("13.64"), result);
  }

  @Test
  void shouldReturnTheValueOfHourExtra() {
    HorasExtrasFimDeSemana sut = new HorasExtrasFimDeSemana();
    BigDecimal salarioBruto = new BigDecimal("3000");
    Float cargaHorariaMensal = 220F;
    BigDecimal valorHora = sut.valorHora(salarioBruto, cargaHorariaMensal);

    BigDecimal result = sut.valorHoraExtra(valorHora);

    assertEquals(new BigDecimal("27.28"), result);
  }
}