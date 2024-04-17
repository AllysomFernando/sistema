package com.fag.sistema.domain.entities.empregado;

import java.time.LocalDate;

import com.fag.sistema.domain.enums.EnumGrauInsalubridade;
import com.fag.sistema.domain.enums.EnumHorarioTrabalho;
import com.fag.sistema.domain.enums.EnumTipoContrato;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contrato {
    private LocalDate dataAdmissao;
    private String cargo;
    private String funcao;
    private EnumGrauInsalubridade grauInsalubridade = EnumGrauInsalubridade.NULO;
    private Salario salario;
    private Boolean ativo;
    private EnumHorarioTrabalho horarioTrabalho = EnumHorarioTrabalho.COMERCIAL;
    private EnumTipoContrato tipoContrato;
    private Beneficios beneficios;
}
