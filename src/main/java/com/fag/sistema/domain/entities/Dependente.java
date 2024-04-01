package com.fag.sistema.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Dependente {
    private String nome;
    private LocalDate dataNascimento;
}
