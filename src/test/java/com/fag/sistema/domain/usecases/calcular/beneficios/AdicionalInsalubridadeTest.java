package com.fag.sistema.domain.usecases.calcular.beneficios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import com.fag.sistema.domain.entities.empregado.Contrato;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empregado.Salario;
import com.fag.sistema.domain.entities.empresa.Empregador;
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

  private Empregador makeEmpresa() {
    Empregador empresa = new Empregador();

    return empresa;
  }

  @Test
  @Description("Should set provento info")
  public void shouldSetProventoInfo() {
    AdicionalInsalubridade sut = new AdicionalInsalubridade();
    Empregado empregado = makeEmpregado(new BigDecimal("2000.00"),
        EnumGrauInsalubridade.BAIXO);
    Empregador empresa = makeEmpresa();

    sut.calculate(empregado, empresa);

    assertEquals("Adicional de Insalubridade", sut.getDescricao());
    assertEquals(10f, sut.getReferencia());
    assertEquals(new BigDecimal("200.00"), sut.getVencimento());
    assertEquals(BigDecimal.ZERO, sut.getDesconto());
  }

  @Test
  @Description("Should calculate Adicional Insalubridade with grau BAIXO")
  public void shouldCalculateAdicionalInsalubridadeGrauBaixo() {
    AdicionalInsalubridade sut = new AdicionalInsalubridade();
    Empregado empregado = makeEmpregado(new BigDecimal("2000.00"),
        EnumGrauInsalubridade.BAIXO);

    Empregador empresa = makeEmpresa();

    BigDecimal beneficio = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("200.00"), beneficio);
  }

  @Test
  @Description("Should calculate Adicional Insalubridade with grau MEDIO")
  public void shouldCalculateAdicionalInsalubridadeGrauMedio() {
    AdicionalInsalubridade sut = new AdicionalInsalubridade();
    Empregado empregado = makeEmpregado(new BigDecimal("2000.00"),
        EnumGrauInsalubridade.MEDIO);

    Empregador empresa = makeEmpresa();

    BigDecimal beneficio = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("400.00"), beneficio);
  }

  @Test
  @Description("Should calculate Adicional Insalubridade with grau ALTO")
  public void shouldCalculateAdicionalInsalubridadeGrauAlto() {
    AdicionalInsalubridade sut = new AdicionalInsalubridade();
    Empregado empregado = makeEmpregado(new BigDecimal("2000.00"),
        EnumGrauInsalubridade.ALTO);

    Empregador empresa = makeEmpresa();

    BigDecimal beneficio = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("800.00"), beneficio);
  }

  @Test
  @Description("Should calculate Adicional Insalubridade with grau NULO")
  public void shouldCalculateAdicionalInsalubridadeGrauNulo() {
    AdicionalInsalubridade sut = new AdicionalInsalubridade();
    Empregado empregado = makeEmpregado(new BigDecimal("2000.00"),
        EnumGrauInsalubridade.NULO);

    Empregador empresa = makeEmpresa();

    BigDecimal beneficio = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("0.00"), beneficio);
  }
}
