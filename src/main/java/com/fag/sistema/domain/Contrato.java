package com.fag.sistema.domain;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Contrato {
    private Date dataAdmissao;
    private String cargo;
    private String funcao;
    private int pisPasep;
    private int horas;

    private Empregador empregador;
    private Salario salario;
}
