package com.fag.sistema.domain.enums;

import java.math.BigDecimal;

public enum EnumBeneficios {
  HORA_EXTRA {
    @Override
    public BigDecimal calculate(BigDecimal salarioBruto) {
      BigDecimal valorHoraExtra = salarioBruto.divide(new BigDecimal(220), 2, BigDecimal.ROUND_HALF_UP);
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
      return null;
    }
  },
  DIARIAS_VIAGEM{
    @Override
    public BigDecimal calculate(BigDecimal salarioBruto) {
      return null;
    }
  };

  public abstract BigDecimal calculate(BigDecimal salarioBruto);

}
