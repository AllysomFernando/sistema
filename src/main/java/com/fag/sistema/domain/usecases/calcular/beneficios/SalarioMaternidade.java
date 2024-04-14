package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.fag.sistema.domain.entities.Provento;
import com.fag.sistema.domain.entities.empregado.Empregado;

@Service
public class SalarioMaternidade extends Provento implements IBeneficioUseCase {

  public SalarioMaternidade() {
    this.setDescricao("Salário Maternidade");
  }

  @Override
  public BigDecimal calculate(Empregado empregado) {
    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();
    BigDecimal referencia = new BigDecimal("0.05");
    BigDecimal beneficiolMensal = salarioBruto.multiply(referencia).setScale(2, RoundingMode.DOWN);

    this.setProvento(getDescricao(), referencia, beneficiolMensal, BigDecimal.ZERO);

    return beneficiolMensal;
  }

}
