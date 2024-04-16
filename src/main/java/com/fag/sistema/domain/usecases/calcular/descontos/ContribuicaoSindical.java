package com.fag.sistema.domain.usecases.calcular.descontos;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

import com.fag.sistema.domain.entities.Provento;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empregador;

@Component
public class ContribuicaoSindical extends Provento implements IDescontoUseCase {

  public ContribuicaoSindical() {
    this.setDescricao("Contribuição Sindical");
  }

  @Override
  public BigDecimal calculate(Empregado empregado, Empregador empresa) {
    BigDecimal referencia = new BigDecimal("50").setScale(2, RoundingMode.DOWN);
    
    this.setProvento(getDescricao(), BigDecimal.ZERO, BigDecimal.ZERO, referencia);
    return referencia;
  }

}
