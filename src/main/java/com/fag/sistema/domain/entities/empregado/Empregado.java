package com.fag.sistema.domain.entities.empregado;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.fag.sistema.domain.enums.EnumGenero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empregado {
    private String nome;
    private EnumGenero genero;
    private String cpf;
    private LocalDate dataNascimento;
    private List<Dependente> dependentes;
    private Horario horario;
    private Contrato contrato;
    private BigDecimal totalDeVendasNoMes;
    private Integer diasEmViagem; // TODO calculo de diarias para viagem

    public Boolean possuiDependente() {
        return this.dependentes != null && !this.dependentes.isEmpty();
    }
}
