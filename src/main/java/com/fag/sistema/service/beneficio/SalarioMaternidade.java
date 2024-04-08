package com.fag.sistema.service.beneficio;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.fag.sistema.domain.entities.Empregado;
import com.fag.sistema.domain.usecases.calcular.beneficios.IBeneficioUseCase;
import org.springframework.stereotype.Service;

@Service
public class SalarioMaternidade implements IBeneficioUseCase {

  @Override
  public BigDecimal calculate(Empregado empregado) {
    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();
    BigDecimal beneficiolMensal = salarioBruto.multiply(new BigDecimal("0.05"));
    return beneficiolMensal.setScale(2, RoundingMode.DOWN);
  }

}
