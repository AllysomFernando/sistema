package com.fag.sistema.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class DependenteDTO {
    private String nome;
    private LocalDate dataNascimento;
}
