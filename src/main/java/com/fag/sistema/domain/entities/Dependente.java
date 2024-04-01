package com.fag.sistema.domain.entities;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Dependente {
    private String nome;
    private LocalDate dataNascimento;
}
