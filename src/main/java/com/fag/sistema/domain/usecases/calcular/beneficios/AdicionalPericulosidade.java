package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.fag.sistema.domain.entities.Provento;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empregador;
import com.fag.sistema.domain.enums.EnumGrauInsalubridade;

@Component
public class AdicionalPericulosidade extends Provento implements IBeneficioUseCase {

  public AdicionalPericulosidade() {
    this.setDescricao("Adicional de Periculosidade");
  }

  @Override
  public BigDecimal calculate(Empregado empregado, Empregador empresa) {
    EnumGrauInsalubridade grauInsalubridade = empregado.getContrato().getGrauInsalubridade();

    if (grauInsalubridade != EnumGrauInsalubridade.NULO) {
      return BigDecimal.ZERO;
    }

    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();
    BigDecimal referencia = new BigDecimal("0.03");
    BigDecimal beneficio = salarioBruto.multiply(referencia).setScale(2);

    this.setProvento(getDescricao(), referencia, beneficio, BigDecimal.ZERO);

    return beneficio;
  }

}
