package com.fag.sistema.domain.entities.empregado;

import java.time.LocalDate;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dependente {
    private String nome;
    private LocalDate dataNascimento;
}

