package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.fag.sistema.domain.entities.Provento;
import com.fag.sistema.domain.entities.empregado.Empregado;

@Component
public class DiariasParaViagem extends Provento implements IBeneficioUseCase {

  // TODO: implementar verificação de viagem do empregado

  public DiariasParaViagem() {
    this.setDescricao("Diarias para Viagem");
  }

  @Override
  public BigDecimal calculate(Empregado empregado) {
    BigDecimal referencia = new BigDecimal("1000.00");

    this.setProvento(getDescricao(), BigDecimal.ZERO, referencia, BigDecimal.ZERO);

    return new BigDecimal("1000.00");
  }

}
