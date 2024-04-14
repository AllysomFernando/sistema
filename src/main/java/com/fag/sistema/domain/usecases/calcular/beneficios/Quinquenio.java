package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.fag.sistema.domain.entities.Provento;
import com.fag.sistema.domain.entities.empregado.Empregado;

@Service
public class Quinquenio extends Provento implements IBeneficioUseCase {

  public Quinquenio() {
    this.setDescricao("Quinquenio");
  }

  @Override
  public BigDecimal calculate(Empregado empregado) {
    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();
    BigDecimal referencia = new BigDecimal("0.03");
    LocalDate dataAdimissao = empregado.getContrato().getDataAdmissao();
    LocalDate now = LocalDate.now();
    BigDecimal beneficio = BigDecimal.ZERO;
    Integer diferencaEmAnos = now.getYear() - dataAdimissao.getYear();

    Integer quinquenios = Math.abs(diferencaEmAnos / 5);

    beneficio = salarioBruto.multiply(referencia);

    beneficio = beneficio.multiply(new BigDecimal(quinquenios)).setScale(2, RoundingMode.DOWN);

    this.setProvento(getDescricao(), referencia, beneficio, BigDecimal.ZERO);

    return beneficio;
  }

}
