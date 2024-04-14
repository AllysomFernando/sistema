package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;

import com.fag.sistema.domain.entities.empregado.Empregado;

public interface IBeneficioUseCase {
  public BigDecimal calculate(Empregado empregado);
}
