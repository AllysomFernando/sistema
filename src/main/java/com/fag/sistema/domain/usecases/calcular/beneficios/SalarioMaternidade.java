package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

import com.fag.sistema.domain.entities.Provento;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empresa;

@Component
public class SalarioMaternidade extends Provento implements IBeneficioUseCase {

  public SalarioMaternidade() {
    super("Salário Maternidade");
  }

  @Override
  public BigDecimal calculate(Empregado empregado, Empresa empresa) {
    if (!empregado.getContrato().getBeneficios().getSalarioMaternidade()) return BigDecimal.ZERO;

    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();
    BigDecimal referencia = new BigDecimal("0.05");
    BigDecimal beneficiolMensal = salarioBruto.multiply(referencia).setScale(2, RoundingMode.DOWN);

    this.setProvento(getDescricao(), referencia, beneficiolMensal, BigDecimal.ZERO);
    empregado.getContrato().getSalario().setBaseCalculoFGTS(beneficiolMensal);

    return beneficiolMensal;
  }

}
