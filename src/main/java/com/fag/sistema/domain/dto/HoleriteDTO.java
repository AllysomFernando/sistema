package com.fag.sistema.domain.dto;

import com.fag.sistema.domain.entities.Provento;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empregador;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HoleriteDTO {
   private Empregador empregador;
   private Empregado empregado;
   private Provento proventos;
}
