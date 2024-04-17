package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.fag.sistema.domain.entities.Provento;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empresa;

@Component
public class DiariasParaViagem extends Provento implements IBeneficioUseCase {

  public DiariasParaViagem() {
    super("Diarias para Viagem");
  }

  @Override
  public BigDecimal calculate(Empregado empregado, Empresa empresa) {
    if (empregado.getDiasEmViagem() < 0) return BigDecimal.ZERO;

    BigDecimal referencia = new BigDecimal("500.00");
    BigDecimal beneficio = referencia.multiply(new BigDecimal(empregado.getDiasEmViagem()));

    this.setProvento(getDescricao(), empregado.getDiasEmViagem(), beneficio, BigDecimal.ZERO);

    return BigDecimal.ZERO;
  }

}
