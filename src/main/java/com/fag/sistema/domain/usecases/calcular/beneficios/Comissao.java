package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.fag.sistema.domain.entities.Provento;
import com.fag.sistema.domain.entities.empregado.Empregado;

@Service
public class Comissao extends Provento implements IBeneficioUseCase {

  public Comissao() {
    this.setDescricao("Comissão");
  }

  public BigDecimal calculate(Empregado empregado) {
    BigDecimal valorVendas = new BigDecimal("1000.00");
    BigDecimal referencia = new BigDecimal("0.06");

    BigDecimal beneficio = valorVendas.multiply(referencia).setScale(2, RoundingMode.DOWN);
    
    this.setProvento(getDescricao(), referencia, beneficio, BigDecimal.ZERO);

    return beneficio;
  }
}
