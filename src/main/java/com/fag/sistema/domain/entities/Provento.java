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
}
