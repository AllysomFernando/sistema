package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.fag.sistema.domain.entities.Provento;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.enums.EnumGrauInsalubridade;

@Service
public class AdicionalInsalubridade extends Provento implements IBeneficioUseCase {

  public AdicionalInsalubridade() {
    this.setDescricao("Adicional de Insalubridade");
  }

  @Override
  public BigDecimal calculate(Empregado empregado) {
    EnumGrauInsalubridade insalubridade = empregado.getContrato().getGrauInsalubridade();
    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();

    BigDecimal beneficio = salarioBruto.multiply(insalubridade.getMultiplicador());
    BigDecimal formatedValue = beneficio.setScale(2, RoundingMode.DOWN); 
    

    this.setReferencia(this.getPorcentagem(insalubridade.getMultiplicador()));
    this.setVencimento(formatedValue);

    return formatedValue;
  }

  private Float getPorcentagem(BigDecimal value) {
    return value.floatValue() * 100;
  }

}
