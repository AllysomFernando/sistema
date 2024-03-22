package com.fag.sistema.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Dependente {
    public String nome;
    public Date data_nascimento;
}
