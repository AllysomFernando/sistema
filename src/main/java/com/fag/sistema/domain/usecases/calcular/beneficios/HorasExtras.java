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
    Float horasASeremFeitas = empresa.getDiasATrabalhar() * empresa.getCargaHorariaDiaria();
    BigDecimal horasASeremFeitasBigDecimal = new BigDecimal(horasASeremFeitas, MathContext.DECIMAL128);
    BigDecimal valorHora = salarioBruto.divide(horasASeremFeitasBigDecimal, 2, RoundingMode.HALF_UP).setScale(2,
        RoundingMode.HALF_UP);
    BigDecimal valorHoraExtraDiasDeSemana = this.valorHoraExtraEmDiasDaSemana(valorHora);

    float quantidadeHorasExtra = empregado.getHorario().getHorasExtras();

    BigDecimal totalHorasExtras = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);

    if (quantidadeHorasExtra > 0) {
      totalHorasExtras = totalHorasExtras
          .add(valorHoraExtraDiasDeSemana.multiply(new BigDecimal(quantidadeHorasExtra)));
    }

    this.setProvento(getDescricao(), quantidadeHorasExtra, totalHorasExtras, BigDecimal.ZERO);
    empregado.getContrato().getSalario().somarBasesDeCalculo(totalHorasExtras);

    return totalHorasExtras;
  }

  public BigDecimal valorHoraExtraEmDiasDaSemana(BigDecimal valorHoraDeTrabalho) {
    BigDecimal referencia = new BigDecimal("0.5");
    BigDecimal result = referencia.multiply(valorHoraDeTrabalho);

    this.setReferencia(referencia);

    return result.add(valorHoraDeTrabalho).setScale(2,RoundingMode.HALF_DOWN);
  }

}
