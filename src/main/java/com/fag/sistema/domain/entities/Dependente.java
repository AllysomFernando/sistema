package com.fag.sistema.domain.entities;

import java.time.LocalDate;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dependente {
    private String nome;
    private LocalDate dataNascimento;
    private String parentesco;
    private String genero;

    public Dependente (String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
}
