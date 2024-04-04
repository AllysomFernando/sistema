package com.fag.sistema.domain.entities;

import java.time.LocalDate;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dependente {
    private String nome;
    private LocalDate dataNascimento;

}
