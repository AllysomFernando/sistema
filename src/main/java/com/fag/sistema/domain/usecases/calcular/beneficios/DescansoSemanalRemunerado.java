package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.fag.sistema.domain.entities.Provento;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empresa;

@Component
public class DescansoSemanalRemunerado extends Provento implements IBeneficioUseCase {

  public DescansoSemanalRemunerado() {
    super("DSR - Descanso Semanal Remunerado");
  }

  @Override
  public BigDecimal calculate(Empregado empregado, Empresa empresa) {
    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();
    Float diasTrabalhados = empresa.getCargaHorariaMensal() / empresa.getCargaHorariaDiaria();
    BigDecimal valorDiaria = salarioBruto.divide(new BigDecimal(diasTrabalhados));

    this.setProvento(getDescricao(), new BigDecimal(diasTrabalhados), valorDiaria, BigDecimal.ZERO);

    empregado.getContrato().getSalario().somarBasesDeCalculo(valorDiaria);

    return valorDiaria;

  }

}
