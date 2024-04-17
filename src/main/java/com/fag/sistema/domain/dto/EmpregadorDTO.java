package com.fag.sistema.domain.dto;

import java.util.List;

import com.fag.sistema.domain.entities.Contato;
import com.fag.sistema.domain.entities.Endereco;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Inscricao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpregadorDTO {
    private String id;
    private String CNPJ;
    private String razaoSocial;
    private String nomeFantasia;
    private String nome;
    private String classificacaoTributaria;
    private String porteEmpresa;
    private String naturezaJuridica;
    private String ramoAtividade;
    private Inscricao inscricao;
    private Contato contato;
    private Endereco endereco;
    private List<Empregado> empregados;
}
