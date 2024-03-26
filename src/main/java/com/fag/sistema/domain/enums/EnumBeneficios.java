package com.fag.sistema.domain.enums;

import com.fag.sistema.domain.Empregado;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum EnumBeneficios {
  HORA_EXTRA {
    @Override
    public BigDecimal calculate(Empregado colaborador) {
      BigDecimal valorHoraExtra = colaborador.getContrato().getSalario().getBruto().divide(new BigDecimal(220)).setScale(2, RoundingMode.HALF_UP);
      return valorHoraExtra.multiply(new BigDecimal("0.5"));
    }
  },
  COMISSAO {
    @Override
    public BigDecimal calculate(BigDecimal salarioBruto) {
      BigDecimal valorVendas = BigDecimal.valueOf(1000);
      return valorVendas.multiply(new BigDecimal("0.06"));
    }
  },
  SALARIO_MATERNIDADE{
    @Override
    public BigDecimal calculate(BigDecimal salarioBruto) {
      return salarioBruto.multiply(new BigDecimal("0.05")).multiply(new BigDecimal("6"));
    }
  },
  QUINQUENIO{
    @Override
    public BigDecimal calculate(BigDecimal salarioBruto) {
      return salarioBruto.multiply(new BigDecimal("0.03"));
    }
  },
  ADICIONAL_NOTURNO{
    @Override
    public BigDecimal calculate(BigDecimal salarioBruto) {
      return salarioBruto.multiply(new BigDecimal("0.15"));
    }
  },
  ADICIONAL_INSALUBRIDADE{
    @Override
    public BigDecimal calculate(BigDecimal salarioBruto) {
      return null;
    }
  },
  ADICIONAL_PERICULOSIDADE{
    @Override
    public BigDecimal calculate(BigDecimal salarioBruto) {
      return salarioBruto.multiply(new BigDecimal("0.30"));
    }
  },
  SALARIO_FAMILIA{
    @Override
    public BigDecimal calculate(BigDecimal salarioBruto) {
      BigDecimal salarioMinimo = new BigDecimal("1100.00");
      return salarioMinimo.multiply(new BigDecimal("0.05"));
    }
  },
  AUXILIO_CRECHE{
    @Override
    public BigDecimal calculate(BigDecimal salarioBruto) {
      return salarioBruto.multiply(new BigDecimal("0.05"));
    }
  },
  DIARIAS_VIAGEM{
    @Override
    public BigDecimal calculate(BigDecimal salarioBruto) {
      return new BigDecimal("1000.000");
    }
  };

  public abstract BigDecimal calculate(Empregado colaborador);

}
