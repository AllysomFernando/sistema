package com.fag.sistema.domain.dto;

import com.fag.sistema.domain.entities.*;
import com.fag.sistema.domain.enums.EnumGenero;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class EmpregadoDTO {
    private String nome;
    private EnumGenero genero;
    private List<Doenca> doencas;
    private String CPF;
    private LocalDate dataNascimento;
    private List<Dependente> dependentes;
    private Horario horario;
    private Contrato contrato;
    private Endereco endereco;
}
