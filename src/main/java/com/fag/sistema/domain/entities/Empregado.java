package com.fag.sistema.domain.entities;

import java.time.LocalDate;
import java.util.List;

import com.fag.sistema.domain.enums.EnumGenero;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empregado {
    private String nome;
    private EnumGenero genero;
    private List<Doenca> doencas;
    private Float peso;
    @JsonProperty("CPF")
    private String CPF;
    private LocalDate dataNascimento;
    private List<Dependente> dependentes;
    private Horario horario;
    private Contrato contrato;
    private Endereco endereco;
}
