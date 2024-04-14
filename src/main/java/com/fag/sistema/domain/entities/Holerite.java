package com.fag.sistema.domain.entities;

import com.fag.sistema.domain.dto.ProventosDTO;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empregador;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Holerite {
    private Empregador empregador;
    private Empregado empregado;
    private ProventosDTO proventos;
}
