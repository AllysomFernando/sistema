package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;

import com.fag.sistema.domain.entities.Empregado;

import org.springframework.stereotype.Service;

@Service
public class DiariasParaViagem implements IBeneficioUseCase {

  // TODO: implementar verificação de viagem do empregado
  @Override
  public BigDecimal calculate(Empregado empregado) {
    return new BigDecimal("1000.00");
  }

}
