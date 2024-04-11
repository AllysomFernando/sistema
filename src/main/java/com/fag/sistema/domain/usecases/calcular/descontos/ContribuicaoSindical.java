package com.fag.sistema.domain.usecases.calcular.descontos;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.fag.sistema.domain.entities.Empregado;

import org.springframework.stereotype.Service;

@Service
public class ContribuicaoSindical implements IDescontoUseCase {

  @Override
  public BigDecimal calculate(Empregado empregado) {
    return new BigDecimal("50").setScale(2, RoundingMode.DOWN);
  }

}
