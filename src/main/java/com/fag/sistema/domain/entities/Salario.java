package com.fag.sistema.domain.entities;

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

  public Salario(BigDecimal bruto) {
    this.bruto = bruto;
  }
}
