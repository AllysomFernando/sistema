package com.fag.sistema.domain.entities;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empregado {
    private String nome;
    private List<Doenca> doencas;
    private Float peso;
    private String cpf;
    private Date dataNascimento;
    private List<Dependente> dependentes;
    private Horario horario;
    private Contrato contrato;
    private Endereco endereco;
}
