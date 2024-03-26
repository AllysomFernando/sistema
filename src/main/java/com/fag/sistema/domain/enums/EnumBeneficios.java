package com.fag.sistema.domain.enums;

import com.fag.sistema.domain.Empregado;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum EnumBeneficios {
  HORA_EXTRA {
    @Override
    public BigDecimal calculate(Empregado colaborador) {
      BigDecimal valorHoraExtra = colaborador.getContrato().getSalario().getBruto().divide(new BigDecimal(220)).setScale(2, RoundingMode.HALF_UP);
      Float hora_extra = colaborador.getHorario().getHoras_extras();
      Float horas_extras_fds = colaborador.getHorario().getHoras_extras_final_de_semana();

      BigDecimal totalHorasExtras = BigDecimal.ZERO;
      if (hora_extra != null){
        totalHorasExtras = totalHorasExtras.add(valorHoraExtra.multiply(new BigDecimal(hora_extra).multiply(new BigDecimal("0.05"))));
      }
      if (horas_extras_fds != null){
        totalHorasExtras = totalHorasExtras.add(valorHoraExtra.multiply(new BigDecimal(horas_extras_fds).multiply(new BigDecimal("0.10"))));
      }

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
