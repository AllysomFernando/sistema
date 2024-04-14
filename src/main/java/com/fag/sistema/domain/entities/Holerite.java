package com.fag.sistema.domain.entities;

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
    private Provento proventos;
}
