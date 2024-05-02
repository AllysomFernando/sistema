package com.fag.sistema.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
  private String rua;
  private String numero;
  private String bairro;
  private String cep;
  private String municipio;
  private String estado;

}
