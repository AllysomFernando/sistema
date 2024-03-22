package com.fag.sistema.domain;

import com.fag.sistema.domain.enums.EnumTipoInscricao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inscricao {
  private EnumTipoInscricao tipoInscricao;
  private String numero;
  private String inscricaoEstadual;
  private String inscricaoMunicipal;
}
