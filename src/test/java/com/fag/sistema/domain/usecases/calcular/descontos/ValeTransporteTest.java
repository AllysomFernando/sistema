package com.fag.sistema.domain.usecases.calcular.descontos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import com.fag.sistema.domain.entities.empregado.Beneficios;
import com.fag.sistema.domain.entities.empregado.Contrato;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empregado.Salario;
import com.fag.sistema.domain.entities.empresa.Empresa;

public class ValeTransporteTest {

  private Empregado makeEmpregadoComSalario(BigDecimal salarioBruto) {
    Empregado empregado = new Empregado();
    Contrato contrato = new Contrato();
    contrato.setBeneficios(new Beneficios(false, true, false, false));
    contrato.setSalario(new Salario(salarioBruto));

    empregado.setContrato(contrato);
    return empregado;
  }

  private Empresa makeEmpresa() {
    Empresa empresa = new Empresa();

    return empresa;
  }

  @Test
  @Description("Should calculate 3% discount from Vale Transporte")
  public void shouldCalculateValeTransporte() {
    ValeTransporte sut = new ValeTransporte();
    Empregado empregado = makeEmpregadoComSalario(new BigDecimal("3000"));

    Empresa empresa = makeEmpresa();
    BigDecimal discount = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("180.00"), discount);
  }
}
