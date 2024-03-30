package com.fag.sistema.domain.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import com.fag.sistema.domain.entities.Contrato;
import com.fag.sistema.domain.entities.Empregado;
import com.fag.sistema.domain.entities.Salario;
import com.fag.sistema.domain.usecases.calcular.descontos.ValeTransporte;

public class ValeTransporteTest {

  private Empregado makeEmpregadoComSalario(BigDecimal salarioBruto) {
    Empregado empregado = new Empregado();
    empregado.setContrato(new Contrato());
    empregado.getContrato().setSalario(new Salario(salarioBruto));

    return empregado;
  }

  @Test
  @Description("Should calculate 3% discount from Vale Transporte")
  public void shouldCalculateValeTransporte() {
    ValeTransporte sut = new ValeTransporte();
    Empregado empregado = makeEmpregadoComSalario(new BigDecimal("3000"));

    BigDecimal discount = sut.calculate(empregado);

    assertEquals(new BigDecimal("90.00"), discount);
  }
}
