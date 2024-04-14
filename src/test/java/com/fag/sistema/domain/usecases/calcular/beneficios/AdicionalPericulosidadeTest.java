package com.fag.sistema.domain.usecases.calcular.beneficios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import com.fag.sistema.domain.entities.empregado.Contrato;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empregado.Salario;
import com.fag.sistema.domain.enums.EnumGrauInsalubridade;

public class AdicionalPericulosidadeTest {
  private Empregado makeEmpregado(BigDecimal salarioBruto) {
    Empregado empregado = new Empregado();
    empregado.setContrato(new Contrato());
    empregado.getContrato().setSalario(new Salario(salarioBruto));

    return empregado;
  }

  @Test
  void shouldAddAdicionalPericulosidade() {
    AdicionalPericulosidade sut = new AdicionalPericulosidade();
    Empregado empregado = makeEmpregado(new BigDecimal("1900.0"));

    BigDecimal beneficio = sut.calculate(empregado);

    assertEquals(new BigDecimal("57.00"), beneficio);
  }

  @Test
  @Description("Should not add Adicional Periculosidade if has grau insalubridade")
  void shouldNotAddAdicionalPericulosidade() {
    AdicionalPericulosidade sut = new AdicionalPericulosidade();
    Empregado empregado = makeEmpregado(new BigDecimal("1900.0"));
    empregado.getContrato().setGrauInsalubridade(EnumGrauInsalubridade.BAIXO);

    BigDecimal beneficio = sut.calculate(empregado);

    assertEquals(BigDecimal.ZERO, beneficio);
  }
}
