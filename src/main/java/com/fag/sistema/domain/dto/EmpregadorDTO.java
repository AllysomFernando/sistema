package com.fag.sistema.domain.dto;

import com.fag.sistema.domain.entities.Contato;
import com.fag.sistema.domain.entities.Endereco;
import com.fag.sistema.domain.entities.Inscricao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpregadorDTO {
    private String CNPJ;
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
