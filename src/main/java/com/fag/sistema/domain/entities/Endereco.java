package com.fag.sistema.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
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
  @JsonProperty("CEP")
  private String CEP;
  private String municipio;
  private String estado;

}
