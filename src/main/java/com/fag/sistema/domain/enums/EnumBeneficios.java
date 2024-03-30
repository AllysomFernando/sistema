package com.fag.sistema.domain.enums;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.fag.sistema.domain.entities.Empregado;

public enum EnumBeneficios {
    HORA_EXTRA {
      @Override
      public BigDecimal calculate(Empregado colaborador) {
        BigDecimal salarioBruto = colaborador.getContrato().getSalario().getBruto();
        BigDecimal valorHora = salarioBruto.divide(new BigDecimal(220), 2, RoundingMode.HALF_UP);

        float horaExtra = colaborador.getHorario().getHoraExtra();
        float horaExtraFDS = colaborador.getHorario().getHoraExtraFDS();

        BigDecimal totalHorasExtras = BigDecimal.ZERO;
        totalHorasExtras = totalHorasExtras.add(valorHora.multiply(new BigDecimal("0.5").multiply(new BigDecimal(horaExtra))));
        totalHorasExtras = totalHorasExtras.add(valorHora.multiply(new BigDecimal("0.10").multiply(new BigDecimal(horaExtraFDS))));

        return totalHorasExtras.setScale(2, RoundingMode.HALF_UP);
      }
  },
  COMISSAO {
    @Override
    public BigDecimal calculate(Empregado colaborador) {
      BigDecimal valorVendas = new BigDecimal("1000.00");
      return valorVendas.multiply(new BigDecimal("0.06"));
    }
  },
  SALARIO_MATERNIDADE{
    @Override
    public BigDecimal calculate(Empregado colaborador) {
      BigDecimal beneficiolMensal = colaborador.getContrato().getSalario().getBruto().multiply(new BigDecimal("0.05"));
      return beneficiolMensal.multiply(new BigDecimal("6"));
    }
  },
  QUINQUENIO{
    @Override
    public BigDecimal calculate(Empregado colaborador) {
      return colaborador.getContrato().getSalario().getBruto().multiply(new BigDecimal("0.03"));
    }
  },
  ADICIONAL_NOTURNO{
    @Override
    public BigDecimal calculate(Empregado colaborador) {
      return colaborador.getContrato().getSalario().getBruto().multiply(new BigDecimal("0.15"));
    }
  },
  ADICIONAL_INSALUBRIDADE{
    @Override
    public BigDecimal calculate(Empregado colaborador) {

        Integer grauInsalubridade = colaborador.getContrato().getGrauInsalubridade();
        BigDecimal salarioBruto = colaborador.getContrato().getSalario().getBruto();

        if(grauInsalubridade == 10) {
          return salarioBruto.multiply(new BigDecimal("0.1"));
        } else if (grauInsalubridade == 20) {
          return salarioBruto.multiply(new BigDecimal("0.2"));
        } else if (grauInsalubridade == 40) {
          return salarioBruto.multiply(new BigDecimal("0.4"));
        } else {
          return salarioBruto.multiply(new BigDecimal("0.0"));
        }
    }
  },
  ADICIONAL_PERICULOSIDADE{
    @Override
    public BigDecimal calculate(Empregado colaborador) {
      return colaborador.getContrato().getSalario().getBruto().multiply(new BigDecimal("0.30"));
    }
  },
  SALARIO_FAMILIA{
    @Override
    public BigDecimal calculate(Empregado colaborador) {
      BigDecimal salarioMinimo = new BigDecimal("1100.00");
      return salarioMinimo.multiply(new BigDecimal("0.05"));
    }
  },
  AUXILIO_CRECHE{
    @Override
    public BigDecimal calculate(Empregado colaborador) {
      return colaborador.getContrato().getSalario().getBruto().multiply(new BigDecimal("0.05"));
    }
  },
  DIARIAS_VIAGEM{
    @Override
    public BigDecimal calculate(Empregado colaborador) {
      return new BigDecimal("1000.000");
    }
  };

  public abstract BigDecimal calculate(Empregado colaborador);

}
