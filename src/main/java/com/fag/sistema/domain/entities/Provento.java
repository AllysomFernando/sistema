package com.fag.sistema.domain.entities;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

    public Provento(String descricao) {
        this.descricao = descricao;
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

    public void setProvento(String descricao, Integer referencia, BigDecimal vencimento, BigDecimal desconto) {
        this.descricao = descricao;
        this.referencia = (float) referencia;
        this.vencimento = vencimento;
        this.desconto = desconto;
    }

    public void setProvento(String descricao, Float referencia, BigDecimal vencimento, BigDecimal desconto) {
        this.descricao = descricao;
        this.referencia = this.getPorcentagem(new BigDecimal(referencia));
        this.vencimento = vencimento;
        this.desconto = desconto;
    }

    public Float getPorcentagem(BigDecimal value) {
        return value.multiply(new BigDecimal("100")).setScale(2, RoundingMode.DOWN).floatValue() * 1.0f;
    }

    public void setReferencia(BigDecimal value) {
        Float porcentagem = this.getPorcentagem(value); 
        this.referencia = porcentagem;
    }

    public void setReferencia(Float value) {
        this.referencia = value;
    }

    public Float getReferencia() {
        return this.referencia * 1.0f;
    }
}
