package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;

import com.fag.sistema.domain.entities.Provento;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empresa;

public class RemuneracaoMensal extends Provento implements IBeneficioUseCase {
  public RemuneracaoMensal() {
    super("Remuneração Mensal");
  }

  @Override
  public BigDecimal calculate(Empregado empregado, Empresa empresa) {
    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();
    Float horasTrabalhadas = empresa.getCargaHorariaDiaria() * empresa.getDiasATrabalhar();

    this.setProvento(getDescricao(), horasTrabalhadas, salarioBruto, BigDecimal.ZERO);

    return BigDecimal.ZERO;
  }
}
