package com.fag.sistema.domain.usecases.calcular.descontos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.fag.sistema.domain.entities.empregado.Contrato;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empregado.Horario;
import com.fag.sistema.domain.entities.empregado.Salario;
import com.fag.sistema.domain.entities.empresa.Empresa;

public class HorasEmDeficitTest {
  
  private Empregado makEmpregado(BigDecimal salarioBruto, Integer horasEmDebito) {
    Empregado empregado = new Empregado();
    Contrato contrato = new Contrato();
    Horario horario = new Horario();
    Salario salario = new Salario(salarioBruto);

    horario.setHorasEmDeficit(horasEmDebito);
    horario.setJustificativa(false);
    contrato.setSalario(salario);

    empregado.setContrato(contrato);
    empregado.setHorario(horario);

    return empregado;
  }

  private Empresa makeEmpresa(Float cargaHorariaDiaria) {
    Empresa empresa = new Empresa();
    empresa.setCargaHorariaDiaria(cargaHorariaDiaria);
    empresa.setDiasATrabalhar(23);

    return empresa;
  }

  @Test
  void shouldCalculateDiscountWith5HoursInDebt() {
    Empregado empregado = makEmpregado(new BigDecimal("3000.00"), 5);
    Empresa empresa = makeEmpresa(8.0f);

    HorasEmDeficit sut = new HorasEmDeficit();

    BigDecimal discount = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("81.50"), discount);
    assertEquals(new BigDecimal("2918.50"), empregado.getContrato().getSalario().getBaseCalculoFGTS());
  }
}
