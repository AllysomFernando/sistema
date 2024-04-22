package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

import com.fag.sistema.domain.entities.Provento;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empresa;

@Component
public class HorasExtras extends Provento implements IBeneficioUseCase {

  public HorasExtras() {
    super("Horas extras");
  }

  @Override
  public BigDecimal calculate(Empregado empregado, Empresa empresa) {
    if (empregado.getHorario().getHorasExtras() < 0) return BigDecimal.ZERO;
    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();
    BigDecimal beneficio = BigDecimal.ZERO;
    Float horasASeremFeitas = empresa.getDiasATrabalhar() * empresa.getCargaHorariaDiaria();
    BigDecimal valorHora = this.valorHora(salarioBruto, horasASeremFeitas);
    BigDecimal valorHoraExtraDiasDeSemana = this.valorHoraExtra(valorHora);

    float quantidadeHorasExtra = empregado.getHorario().getHorasExtras();

    if (quantidadeHorasExtra > 0) {
      beneficio = beneficio
          .add(valorHoraExtraDiasDeSemana.multiply(new BigDecimal(quantidadeHorasExtra)));
    }

    this.setProvento(getDescricao(), quantidadeHorasExtra, beneficio, BigDecimal.ZERO);
    empregado.getContrato().getSalario().somarBasesDeCalculo(beneficio);

    return beneficio;
  }

  public BigDecimal valorHoraExtra(BigDecimal valorHoraDeTrabalho) {
    BigDecimal referencia = new BigDecimal("0.5");
    BigDecimal result = referencia.multiply(valorHoraDeTrabalho).setScale(2,RoundingMode.HALF_DOWN);

    this.setReferencia(referencia);

    return result.add(valorHoraDeTrabalho);
  }

  public BigDecimal valorHora(BigDecimal salario, Float horasTrabalhadas) {
    BigDecimal horasASeremFeitasBigDecimal = new BigDecimal(horasTrabalhadas, MathContext.DECIMAL128);
    BigDecimal valorHora = salario.divide(horasASeremFeitasBigDecimal, 2, RoundingMode.HALF_UP);

    return valorHora;
  }

}
