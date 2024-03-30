package com.fag.sistema.domain.usecases.calcular.descontos;

import java.math.BigDecimal;

import com.fag.sistema.domain.entities.Empregado;

public interface IDescontoUseCase {
  public BigDecimal calculate(Empregado empregado);
}
