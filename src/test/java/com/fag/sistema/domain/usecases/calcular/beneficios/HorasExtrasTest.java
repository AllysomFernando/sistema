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

public class HorasExtrasTest {

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
  void shouldNotUpdateBaseDeCalculos() {
    HorasExtras sut = new HorasExtras();
    Empregado empregado = makeEmpregado(new BigDecimal("3000"), 7);
    Empresa empresa = makeEmpresa(168F);

    BigDecimal result = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("187.53"), result);
  }

  @Test
  void shouldReturn50PlusOfValorHora() {
    HorasExtras sut = new HorasExtras();
    BigDecimal valorHora = new BigDecimal("17.85");

    BigDecimal result = sut.valorHoraExtra(valorHora);

    assertEquals(new BigDecimal("26.77"), result);
  }

  @Test
  @Description("Should return the value of hour worked of an employee")
  void shouldReturnValorHora() {
    HorasExtras sut = new HorasExtras();
    BigDecimal salarioBruto = new BigDecimal("3000");
    Float cargaHorariaMensal = 220F;

    BigDecimal result = sut.valorHora(salarioBruto, cargaHorariaMensal);

    assertEquals(new BigDecimal("13.64"), result);
  }

  @Test
  @Description("Should return the value of hour worked + 50% of an employee")
  void shouldReturnValorHoraExtra() {
    HorasExtras sut = new HorasExtras();
    BigDecimal salarioBruto = new BigDecimal("3000");
    BigDecimal valorHora = sut.valorHora(salarioBruto, 220F);

    BigDecimal result = sut.valorHoraExtra(valorHora);

    assertEquals(new BigDecimal("20.46"), result);
  }

  @Test
  void shouldReturnTheValueOfBonusForAnEmployee() {
    HorasExtras sut = new HorasExtras();
    Empregado empregado = makeEmpregado(new BigDecimal("3000"), 10);
    Empresa empresa = makeEmpresa(220F);

    BigDecimal result = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("204.60"), result);
  }
}
