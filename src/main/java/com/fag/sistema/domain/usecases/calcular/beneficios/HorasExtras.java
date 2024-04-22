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
    BigDecimal beneficio = BigDecimal.ZERO;
    Float cargaHorariaMensal = empresa.getCargaHorariaMensal();
    BigDecimal valorHora = this.valorHora(salarioBruto, cargaHorariaMensal);
    BigDecimal valorHoraExtra = this.valorHoraExtra(valorHora);

    float quantidadeHorasExtra = empregado.getHorario().getHorasExtras();

    if (quantidadeHorasExtra > 0) {
      beneficio = beneficio
          .add(valorHoraExtra.multiply(new BigDecimal(quantidadeHorasExtra)));
    }

    this.setProvento(getDescricao(), quantidadeHorasExtra, beneficio, BigDecimal.ZERO);
    empregado.getContrato().getSalario().somarBasesDeCalculo(beneficio);

    return beneficio;
  }

  public BigDecimal valorHoraExtra(BigDecimal valorHoraDeTrabalho) {
    BigDecimal referencia = new BigDecimal("0.5");
    BigDecimal result = referencia.multiply(valorHoraDeTrabalho).setScale(2,RoundingMode.HALF_DOWN);

    this.setReferencia(referencia);

    return result.add(valorHoraDeTrabalho);
  }

  public BigDecimal valorHora(BigDecimal salario, Float horasTrabalhadasNoMes) {
    BigDecimal horasASeremFeitasBigDecimal = new BigDecimal(horasTrabalhadasNoMes, MathContext.DECIMAL128);
    BigDecimal valorHora = salario.divide(horasASeremFeitasBigDecimal, 2, RoundingMode.HALF_DOWN);

    return valorHora;
  }

}
