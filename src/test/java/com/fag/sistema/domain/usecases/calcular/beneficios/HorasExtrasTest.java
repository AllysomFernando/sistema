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

  private Empregado makeEmpregado(BigDecimal salarioBruto, int horaTrabalhada, float horasExtras) {
    Empregado empregado = new Empregado();
    Horario horario = new Horario();
    Contrato contrato = new Contrato();
    Salario salario = new Salario(salarioBruto);

    horario.setHorasExtras(horasExtras);
    horario.setHoraTrabalhada(horaTrabalhada);
    contrato.setSalario(salario);
    salario.setBruto(salarioBruto);

    empregado.setContrato(contrato);
    empregado.setHorario(horario);

    return empregado;
  }

  private Empresa makeEmpresa() {
    Empresa empresa = new Empresa();
    empresa.setDiasATrabalhar(21);
    empresa.setCargaHorariaDiaria(8f);

    return empresa;
  }

  @Test
  @Description("Deve retornar R$174,93")
  void shouldNotUpdateBaseDeCalculos() {
    HorasExtras sut = new HorasExtras();
    Empregado empregado = makeEmpregado(new BigDecimal("3000"), 168, 7);
    Empresa empresa = makeEmpresa();

    BigDecimal result = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("175.035"), result);
  }

  @Test
  void shouldReturn50PlusOfValorHora() {
    HorasExtras sut = new HorasExtras();
    BigDecimal valorHora = new BigDecimal("17.85");

    BigDecimal result = sut.valorHoraExtraEmDiasDaSemana(valorHora);

    assertEquals(new BigDecimal("26.77"), result);
  }
}
