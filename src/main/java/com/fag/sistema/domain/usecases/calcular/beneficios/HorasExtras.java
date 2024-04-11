package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.fag.sistema.domain.entities.Empregado;

import org.springframework.stereotype.Service;

@Service
public class HorasExtras implements IBeneficioUseCase {

  @Override
  public BigDecimal calculate(Empregado empregado) {
    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();
    BigDecimal valorHora = salarioBruto.divide(new BigDecimal("220")).setScale(2, RoundingMode.HALF_UP);
    BigDecimal valorHoraExtraDiasDeSemana = this.valorHoraExtraEmDiasDaSemana(valorHora);
    BigDecimal valorHoraExtraFimsDeSemana = this.valorHoraExtraEmFimsDeSemana(valorHora);

    float quantidadeHorasExtra = empregado.getHorario().getHoraExtra();
    float quantidadeHoraExtraFDS = empregado.getHorario().getHoraExtraFDS();

    BigDecimal totalHorasExtras = BigDecimal.ZERO;

    if (quantidadeHorasExtra > 0) {
      totalHorasExtras = totalHorasExtras
          .add(valorHoraExtraDiasDeSemana.multiply(new BigDecimal(quantidadeHorasExtra)));
    }

    if (quantidadeHoraExtraFDS > 0) {
      totalHorasExtras = totalHorasExtras
          .add(valorHoraExtraFimsDeSemana.multiply(new BigDecimal(quantidadeHoraExtraFDS)));
    }

    return totalHorasExtras.setScale(2, RoundingMode.HALF_UP);
  }

  private BigDecimal valorHoraExtraEmDiasDaSemana(BigDecimal valorHoraDeTrabalho) {
    BigDecimal result = new BigDecimal("0.5").multiply(valorHoraDeTrabalho);

    return result.add(valorHoraDeTrabalho);
  }

  private BigDecimal valorHoraExtraEmFimsDeSemana(BigDecimal valorHoraDeTrabalho) {
    BigDecimal result = new BigDecimal("1.0").multiply(valorHoraDeTrabalho);

    return result.add(valorHoraDeTrabalho);
  }

}
