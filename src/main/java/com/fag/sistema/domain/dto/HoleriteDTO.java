package com.fag.sistema.domain.dto;

import com.fag.sistema.domain.entities.Empregado;
import com.fag.sistema.domain.entities.Empregador;
import com.fag.sistema.domain.entities.Provento;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HoleriteDTO {
   private Empregador empregador;
   private Empregado empregado;
   private Provento proventos;
}
