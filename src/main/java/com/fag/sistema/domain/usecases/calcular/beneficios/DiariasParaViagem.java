package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.fag.sistema.domain.entities.empregado.Empregado;

@Service
public class DiariasParaViagem implements IBeneficioUseCase {

  // TODO: implementar verificação de viagem do empregado
  @Override
  public BigDecimal calculate(Empregado empregado) {
    return new BigDecimal("1000.00");
  }

}
