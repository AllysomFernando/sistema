package com.fag.sistema.domain.usecases.calcular.descontos;

import java.math.BigDecimal;

import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empresa;

public interface IDescontoEmFolhaUseCase {
  public BigDecimal calculate(Empregado empregado, Empresa empresa);
}
