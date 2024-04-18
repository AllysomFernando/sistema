package com.fag.sistema.domain.entities;

import java.math.BigDecimal;
import java.util.List;

import com.fag.sistema.domain.usecases.calcular.beneficios.IBeneficioUseCase;
import com.fag.sistema.domain.usecases.calcular.descontos.IDescontoEmFolhaUseCase;
import com.fag.sistema.domain.usecases.calcular.descontos.IDescontoUseCase;

import lombok.Data;

@Data
public class Proventos {
  private BigDecimal totalBeneficios;
  private BigDecimal totalDescontos;
  private List<IBeneficioUseCase> beneficios;
  private List<IDescontoUseCase> descontos;
  private List<IDescontoEmFolhaUseCase> descontosEmFolha;
}
