package com.fag.sistema.service.descontos;

import java.math.BigDecimal;

import com.fag.sistema.domain.entities.Empregado;
import com.fag.sistema.domain.usecases.calcular.descontos.IDescontoUseCase;
import org.springframework.stereotype.Service;

@Service
public class FGTS implements IDescontoUseCase {

  @Override
  public BigDecimal calculate(Empregado empregado) {
    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();
    return salarioBruto.multiply(new BigDecimal("0.08"));
  }

}
