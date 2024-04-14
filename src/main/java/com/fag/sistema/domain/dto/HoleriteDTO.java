package com.fag.sistema.domain.dto;

import com.fag.sistema.domain.entities.Empregador;
import com.fag.sistema.domain.entities.Provento;
import com.fag.sistema.domain.entities.empregado.Empregado;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HoleriteDTO {
   private Empregador empregador;
   private Empregado empregado;
   private Provento proventos;
}
