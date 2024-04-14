package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.fag.sistema.domain.entities.empregado.Empregado;

@Service
public class Comissao implements IBeneficioUseCase {
  public BigDecimal calculate(Empregado empregado) {
    BigDecimal valorVendas = new BigDecimal("1000.00");
    return valorVendas.multiply(new BigDecimal("0.06"));
  }
}
