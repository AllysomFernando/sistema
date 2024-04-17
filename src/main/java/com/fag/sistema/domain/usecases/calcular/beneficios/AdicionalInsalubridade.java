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
    super("Adicional de Insalubridade");
  }

  @Override
  public BigDecimal calculate(Empregado empregado, Empresa empresa) {
    EnumGrauInsalubridade insalubridade = empregado.getContrato().getGrauInsalubridade();
    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();

    BigDecimal beneficio = salarioBruto.multiply(insalubridade.getMultiplicador()).setScale(2);

    this.setProvento(getDescricao(), insalubridade.getMultiplicador(), beneficio, BigDecimal.ZERO);
    empregado.getContrato().getSalario().somarBasesDeCalculo(beneficio);

    return beneficio;
  }

}
