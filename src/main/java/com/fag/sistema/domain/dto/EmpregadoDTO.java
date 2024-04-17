package com.fag.sistema.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.fag.sistema.domain.entities.empregado.Contrato;
import com.fag.sistema.domain.entities.empregado.Dependente;
import com.fag.sistema.domain.entities.empregado.Doenca;
import com.fag.sistema.domain.entities.empregado.Horario;
import com.fag.sistema.domain.enums.EnumGenero;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpregadoDTO {
    private String nome;
    private EnumGenero genero;
    private List<Doenca> doencas;
    private String cpf;
    private LocalDate dataNascimento;
    private List<Dependente> dependentes;
    private Horario horario;
    private Contrato contrato;
    private BigDecimal totalDeVendasNoMes;
    private Integer diasEmViagem;
}
