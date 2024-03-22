package com.fag.sistema.domain;

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
}
