package com.fag.sistema.domain.usecases.calcular.descontos;

import java.math.BigDecimal;

import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empregador;

public interface IDescontoUseCase {
  public BigDecimal calculate(Empregado empregado, Empregador empresa);
}
