package com.fag.sistema.domain.entities.empresa;

import java.util.List;

import com.fag.sistema.domain.entities.empregado.Empregado;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empregador {
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String ramoAtividade;
    private Inscricao inscricao;
    private Float cargaHorariaDiaria;
    private Integer diasATrabalhar;
    private List<Empregado> empregados;

    public void adicionarEmpregado(Empregado empregado) {
        this.empregados.add(empregado);
    }
}
