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

    public void setProvento(String descricao, BigDecimal referencia, BigDecimal vencimento, BigDecimal desconto) {
        this.descricao = descricao;
        this.referencia = this.getPorcentagem(referencia);
        this.vencimento = vencimento;
        this.desconto = desconto;
    }

    public Float getPorcentagem(BigDecimal value) {
        return value.floatValue() * 100.0f;
    }

    public void setReferencia(BigDecimal value) {
        this.referencia = this.getPorcentagem(value);
    }

    public void setReferencia(Float value) {
        this.referencia = value;
    }

    public Float getReferencia() {
        return Math.round(this.referencia) * 1.0f;
    }
}
