package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

import com.fag.sistema.domain.entities.Provento;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empresa;

@Component
public class HorasExtrasFimDeSemana extends Provento implements IBeneficioUseCase {
  public HorasExtrasFimDeSemana() {
    super("Horas extras em fins de semana");
  }

  @Override
  public BigDecimal calculate(Empregado empregado, Empresa empresa) {
    if (empregado.getHorario().getHorasExtrasEmFinsDeSemana() < 0) return BigDecimal.ZERO;
    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();
    BigDecimal valorHora = this.valorHora(salarioBruto, empresa.getCargaHorariaMensal());

    BigDecimal valorHoraExtraFimsDeSemana = this.valorHoraExtra(valorHora);

    float quantidadeHoraExtraFDS = empregado.getHorario().getHorasExtrasEmFinsDeSemana();

    BigDecimal totalHorasExtras = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_DOWN);

    if (quantidadeHoraExtraFDS > 0) {
      totalHorasExtras = totalHorasExtras
          .add(valorHoraExtraFimsDeSemana.multiply(new BigDecimal(quantidadeHoraExtraFDS)));
    }

    this.setProvento(getDescricao(), quantidadeHoraExtraFDS, totalHorasExtras, BigDecimal.ZERO);
    empregado.getContrato().getSalario().somarBasesDeCalculo(totalHorasExtras);

    return totalHorasExtras;
  }
  
  public BigDecimal valorHora(BigDecimal salario, Float cargaHorariaMensal) {
    BigDecimal horasASeremFeitasBigDecimal = new BigDecimal(cargaHorariaMensal, MathContext.DECIMAL128);
    BigDecimal valorHora = salario.divide(horasASeremFeitasBigDecimal, 2, RoundingMode.HALF_DOWN);

    return valorHora;
  }

  public BigDecimal valorHoraExtra(BigDecimal valorHoraDeTrabalho) {
    BigDecimal referencia = new BigDecimal("1.0");
    BigDecimal result = referencia.multiply(valorHoraDeTrabalho).setScale(2, RoundingMode.HALF_DOWN);

    this.setReferencia(referencia);

    return result.add(valorHoraDeTrabalho);
  }
}
