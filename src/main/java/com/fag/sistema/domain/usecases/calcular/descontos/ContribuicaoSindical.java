package com.fag.sistema.domain.usecases.calcular.descontos;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

import com.fag.sistema.domain.entities.Provento;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empresa;

@Component
public class ContribuicaoSindical extends Provento implements IDescontoUseCase {

  public ContribuicaoSindical() {
    super("Contribuição Sindical");
  }

  @Override
  public BigDecimal calculate(Empregado empregado, Empresa empresa) {
    if (!empregado.getContrato().getBeneficios().getContribuicaoSindical()) return BigDecimal.ZERO;
    BigDecimal referencia = new BigDecimal("50").setScale(2, RoundingMode.DOWN);
    
    this.setProvento(getDescricao(), BigDecimal.ZERO, BigDecimal.ZERO, referencia);
    return referencia;
  }

}
