package com.fag.sistema.domain.entities.empresa;

import java.util.List;

import com.fag.sistema.domain.entities.Contato;
import com.fag.sistema.domain.entities.Endereco;
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
    private String classificacaoTributaria;
    private String porteEmpresa;
    private String naturezaJuridica;
    private String ramoAtividade;
    private Inscricao inscricao;
    private Float cargaHorariaDiaria;
    private Integer diasATrabalhar;
    private Contato contato;
    private Endereco endereco;
    private List<Empregado> empregados;
}
