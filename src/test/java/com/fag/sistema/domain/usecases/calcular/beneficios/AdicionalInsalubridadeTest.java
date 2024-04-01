package com.fag.sistema.domain.usecases.calcular.beneficios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import com.fag.sistema.domain.entities.Contrato;
import com.fag.sistema.domain.entities.Empregado;
import com.fag.sistema.domain.entities.Salario;
import com.fag.sistema.domain.enums.EnumGrauInsalubridade;

public class AdicionalInsalubridadeTest {
  private Empregado makeEmpregado(BigDecimal salarioBruto,
      EnumGrauInsalubridade grauInsalubridade) {
    Empregado empregado = new Empregado();
    empregado.setContrato(new Contrato());
    empregado.getContrato().setSalario(new Salario(salarioBruto));
    empregado.getContrato().setGrauInsalubridade(grauInsalubridade);

    return empregado;
  }

  @Test
  @Description("Should calculate Adicional Insalubridade with grau 10")
  public void shouldCalculateAdicionalInsalubridade() {
    AdicionalInsalubridade sut = new AdicionalInsalubridade();
    Empregado empregado = makeEmpregado(new BigDecimal("1900.0"),
        EnumGrauInsalubridade.BAIXO);

    BigDecimal beneficio = sut.calculate(empregado);

    assertEquals(new BigDecimal("190.00"), beneficio);
  }
}
