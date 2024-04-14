package com.fag.sistema.domain.entities;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Provento {
    private String descricao;
    private Float referencia;
    private BigDecimal vencimento;
    private BigDecimal desconto;

    public Provento() {
        this.descricao = "";
        this.referencia = 0.0f;
        this.vencimento = BigDecimal.ZERO;
        this.desconto = BigDecimal.ZERO;
    }
}
