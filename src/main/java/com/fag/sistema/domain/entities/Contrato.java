package com.fag.sistema.domain.entities;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contrato {

    private Date dataAdmissao;
    private String cargo;
    private String funcao;
    private int pisPasep;
    private int horas;
    private Integer grauInsalubridade;
    private Empregador empregador;
    private Salario salario;
}
