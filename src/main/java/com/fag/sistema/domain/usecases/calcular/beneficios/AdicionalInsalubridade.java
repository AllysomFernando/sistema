package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.fag.sistema.domain.entities.Provento;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empresa;
import com.fag.sistema.domain.enums.EnumGrauInsalubridade;

@Component
public class AdicionalInsalubridade extends Provento implements IBeneficioUseCase {

  public AdicionalInsalubridade() {
    this.setDescricao("Adicional de Insalubridade");
  }

  @Override
  public BigDecimal calculate(Empregado empregado, Empresa empresa) {
    EnumGrauInsalubridade insalubridade = empregado.getContrato().getGrauInsalubridade();
    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();

    BigDecimal beneficio = salarioBruto.multiply(insalubridade.getMultiplicador());
    BigDecimal formatedValue = beneficio.setScale(2); 

    this.setProvento("Adicional de Insalubridade", insalubridade.getMultiplicador(), formatedValue, BigDecimal.ZERO);

    empregado.getContrato().getSalario().somarBasesDeCalculo(formatedValue);

    return formatedValue;
  }

}
