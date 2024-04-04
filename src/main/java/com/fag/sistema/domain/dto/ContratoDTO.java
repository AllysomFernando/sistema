package com.fag.sistema.domain.dto;

import com.fag.sistema.domain.entities.Empregador;
import com.fag.sistema.domain.entities.Salario;
import com.fag.sistema.domain.enums.EnumGrauInsalubridade;
import com.fag.sistema.domain.enums.EnumHorarioTrabalho;
import com.fag.sistema.domain.enums.EnumTipoContrato;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ContratoDTO {
    private LocalDate dataAdmissao;
    private String cargo;
    private String funcao;
    private int pisPasep;
    private int horas;
    private EnumGrauInsalubridade grauInsalubridade = EnumGrauInsalubridade.NULO;
    private Empregador empregador;
    private Salario salario;
    private EnumHorarioTrabalho horarioTrabalho = EnumHorarioTrabalho.COMERCIAL;
    private EnumTipoContrato tipoContrato;
    private String descricao;
}
