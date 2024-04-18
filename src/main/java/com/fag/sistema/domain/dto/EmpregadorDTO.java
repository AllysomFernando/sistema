package com.fag.sistema.domain.dto;

import java.util.HashMap;
import java.util.List;

import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Inscricao;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class EmpregadorDTO {
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String ramoAtividade;
    private Inscricao inscricao;
    private Float cargaHorariaDiaria;
    private Integer diasATrabalhar;
    private List<Empregado> empregados;
    private List<Empregado> funcionariasComSalarioMaternidade;
    private HashMap<String, List<Empregado>> funcionariosAgrupados;
}
