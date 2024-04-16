package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

import com.fag.sistema.domain.entities.Provento;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empregador;

@Component
public class HorasExtras extends Provento implements IBeneficioUseCase {

  public HorasExtras() {
    this.setDescricao("Horas extras");
  }

  @Override
  public BigDecimal calculate(Empregado empregado, Empregador empresa) {
    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();
    BigDecimal valorHora = salarioBruto.divide(new BigDecimal("220"), 2, RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP);
    BigDecimal valorHoraExtraDiasDeSemana = this.valorHoraExtraEmDiasDaSemana(valorHora);

    float quantidadeHorasExtra = empregado.getHorario().getHorasExtras();

    BigDecimal totalHorasExtras = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);

    if (quantidadeHorasExtra > 0) {
      totalHorasExtras = totalHorasExtras
          .add(valorHoraExtraDiasDeSemana.multiply(new BigDecimal(quantidadeHorasExtra)));
    }

    this.setVencimento(totalHorasExtras);

    return totalHorasExtras;
  }

  private BigDecimal valorHoraExtraEmDiasDaSemana(BigDecimal valorHoraDeTrabalho) {
    BigDecimal referencia = new BigDecimal("0.5"); 
    BigDecimal result = referencia.multiply(valorHoraDeTrabalho);

    this.setReferencia(referencia);

    return result.add(valorHoraDeTrabalho);
  }

}
