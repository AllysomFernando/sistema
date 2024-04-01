package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import com.fag.sistema.domain.entities.Empregado;

public class Quinquenio implements IBeneficioUseCase {

  @Override
  public BigDecimal calculate(Empregado empregado) {
    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();
    LocalDate dataAdimissao = empregado.getContrato().getDataAdmissao();
    LocalDate now = LocalDate.now();
    BigDecimal beneficio = BigDecimal.ZERO;
    Integer diferencaEmAnos = now.getYear() - dataAdimissao.getYear();

    Integer quinquenios = Math.abs(diferencaEmAnos / 5);

    beneficio = salarioBruto.multiply(new BigDecimal("0.03"));

    beneficio = beneficio.multiply(new BigDecimal(quinquenios));

    return beneficio.setScale(2, RoundingMode.DOWN);
  }

}
