package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

import com.fag.sistema.domain.entities.Provento;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empresa;

@Component
public class HorasExtrasFimDeSemana extends Provento implements IBeneficioUseCase {
  public HorasExtrasFimDeSemana() {
    this.setDescricao("Horas extras em fins de semana");
  }

  @Override
  public BigDecimal calculate(Empregado empregado, Empresa empresa) {
    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();
    BigDecimal valorHora = salarioBruto.divide(new BigDecimal("220"), 2, RoundingMode.HALF_UP).setScale(2,
        RoundingMode.HALF_UP);

    BigDecimal valorHoraExtraFimsDeSemana = this.valorHoraExtraEmFimsDeSemana(valorHora);

    float quantidadeHoraExtraFDS = empregado.getHorario().getHorasExtrasEmFinsDeSemana();

    BigDecimal totalHorasExtras = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);

    if (quantidadeHoraExtraFDS > 0) {
      totalHorasExtras = totalHorasExtras
          .add(valorHoraExtraFimsDeSemana.multiply(new BigDecimal(quantidadeHoraExtraFDS)));
    }

    this.setVencimento(totalHorasExtras);

    return totalHorasExtras;
  }

  private BigDecimal valorHoraExtraEmFimsDeSemana(BigDecimal valorHoraDeTrabalho) {
    BigDecimal referencia = new BigDecimal("1.0");
    BigDecimal result = referencia.multiply(valorHoraDeTrabalho);

    this.setReferencia(referencia);

    return result.add(valorHoraDeTrabalho);
  }
}
