package com.fag.sistema.domain.entities;

import java.time.LocalDate;
import java.util.List;

import com.fag.sistema.domain.enums.EnumGenero;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empregado {
    private String nome;
    private EnumGenero genero;
    private List<Doenca> doencas;
    @JsonProperty("CPF")
    private String CPF;
    private LocalDate dataNascimento;
    private List<Dependente> dependentes;
    private Horario horario;
    private Contrato contrato;
    private Endereco endereco;
}
