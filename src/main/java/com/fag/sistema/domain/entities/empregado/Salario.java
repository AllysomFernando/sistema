package com.fag.sistema.domain.entities.empregado;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Salario {
  private BigDecimal bruto;
  private BigDecimal liquido;
  private BigDecimal base;
  private BigDecimal baseCalculoIRRF;
  private BigDecimal baseCalculoFGTS;

  public Salario(BigDecimal bruto) {
    this.bruto = bruto;
  }
}
