package com.fag.sistema.domain.usecases.calcular.beneficios;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import com.fag.sistema.domain.entities.empregado.Contrato;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empregado.Salario;
import com.fag.sistema.domain.entities.empresa.Empresa;

public class DiariasParaViagemTest {

  private Empregado makeEmpregado(BigDecimal salarioBruto, Integer diasViajados) {
    Empregado empregado = new Empregado();
    empregado.setContrato(new Contrato());
    empregado.getContrato().setSalario(new Salario(salarioBruto));
    empregado.setDiasEmViagem(diasViajados);

    return empregado;
  }

  private Empresa makeEmpresa() {
    Empresa empresa = new Empresa();

    return empresa;
  }

  @Test
  @Description("Should not update base de calculos")
  void shouldNotUpdateBaseDeCalculos() {
    DiariasParaViagem sut = new DiariasParaViagem();
    Empregado empregado = makeEmpregado(new BigDecimal("2000"), 2);
    Empresa empresa = makeEmpresa();

    sut.calculate(empregado, empresa);

    assertAll("Bases de calculos",
        () -> assertEquals(new BigDecimal("2000.00"), empregado.getContrato().getSalario().getBaseCalculoInss()),
        () -> assertEquals(new BigDecimal("2000.00"), empregado.getContrato().getSalario().getBaseCalculoFGTS()),
        () -> assertEquals(new BigDecimal("2000.00"), empregado.getContrato().getSalario().getBaseCalculoIRRF()));

  }

  @Test
  void shouldAddDiariasParaViagem() {
    DiariasParaViagem sut = new DiariasParaViagem();
    Empregado empregado = makeEmpregado(new BigDecimal("2000.00"), 2);
    Empresa empresa = makeEmpresa();

    sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("1000.00"), sut.getVencimento());
  }

  @Test
  void shouldSetZeroIfEmpregadoHanstTravel() {
    DiariasParaViagem sut = new DiariasParaViagem();
    Empregado empregado = makeEmpregado(new BigDecimal("2000.00"), 0);
    Empresa empresa = makeEmpresa();

    sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("0.00"), sut.getVencimento());
  }
}
