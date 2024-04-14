package com.fag.sistema.domain.entities.empresa;

import com.fag.sistema.domain.entities.Contato;
import com.fag.sistema.domain.entities.Endereco;

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
    private Contato contato;
    private Endereco endereco;
}
