package com.fag.sistema.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empregador {
    @JsonProperty("CNPJ")
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
