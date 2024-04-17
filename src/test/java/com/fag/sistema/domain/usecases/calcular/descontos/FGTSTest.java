package com.fag.sistema.domain.usecases.calcular.descontos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.fag.sistema.domain.entities.empregado.Contrato;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empregado.Salario;
import com.fag.sistema.domain.entities.empresa.Empregador;

public class FGTSTest {

  private Empregador makeEmpresa() {
    Empregador empresa = new Empregador();

    return empresa;
  }

  private Empregado makeEmpregado() {
    Empregado empregado = new Empregado();
    BigDecimal salarioBruto = new BigDecimal("3000");
    empregado.setContrato(new Contrato());
    empregado.getContrato().setSalario(new Salario(salarioBruto));

    return empregado;
  }

  @Test
  public void shouldCalculateFGTSIfSalaryIsThreeThousand() {
    FGTS sut = new FGTS();
    Empregado empregado = makeEmpregado();
    Empregador empresa = makeEmpresa();

    BigDecimal discount = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("240.00"), discount);
  }
}
