package com.fag.sistema.domain.entities.empregado;

import java.time.LocalDate;

import com.fag.sistema.domain.entities.empresa.Empregador;
import com.fag.sistema.domain.enums.EnumGrauInsalubridade;
import com.fag.sistema.domain.enums.EnumHorarioTrabalho;

import com.fag.sistema.domain.enums.EnumTipoContrato;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contrato {
    private LocalDate dataAdmissao;
    private String cargo;
    private String funcao;
    private int pisPasep;
    private int horas;
    private EnumGrauInsalubridade grauInsalubridade = EnumGrauInsalubridade.NULO;
    private Empregador empregador;
    private Salario salario;
    private Boolean ativo;
    private EnumHorarioTrabalho horarioTrabalho = EnumHorarioTrabalho.COMERCIAL;
    private EnumTipoContrato tipoContrato;
    private String descricao;
}