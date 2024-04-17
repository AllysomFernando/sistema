package com.fag.sistema.domain.entities.empregado;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Beneficios {
  private Boolean valeAlimentacao;
  private Boolean valeTransporte;
  private Boolean salarioMaternidade;
  private Boolean adicionalPericulosidade;

  public Beneficios() {
    valeAlimentacao = false;
    valeTransporte = false;
    salarioMaternidade = false;
    adicionalPericulosidade = false;
  }
}
