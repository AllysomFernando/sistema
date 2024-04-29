package com.fag.sistema.domain.usecases.calcular.descontos;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

import com.fag.sistema.domain.entities.Provento;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empresa;
import com.fag.sistema.domain.enums.RelacaoIRRF;

@Component
public class IRRF extends Provento implements IDescontoEmFolhaUseCase {

  public IRRF() {
    super("IRRF");
  }

  @Override
  public BigDecimal calculate(Empregado empregado, Empresa empresa) {

    BigDecimal salarioParaIRRF = empregado.getContrato().getSalario().getBaseCalculoIRRF();
    BigDecimal referencia = new BigDecimal("0.00");
    BigDecimal discountValue = new BigDecimal("0.00");
    RelacaoIRRF[] relacaoIrrf = RelacaoIRRF.values();

    for (RelacaoIRRF element : relacaoIrrf) {
      if (element.compare(salarioParaIRRF)) {
        referencia = element.getReferencia();
        discountValue = this.getDesconto(salarioParaIRRF, element);
        break;
      }
    }

    this.setProvento(getDescricao(), referencia, BigDecimal.ZERO, discountValue);
    return discountValue;
  }

  public BigDecimal getDesconto(BigDecimal salario, RelacaoIRRF relacao) {
    BigDecimal descontoSalarial = salario.multiply(relacao.getReferencia()).setScale(2, RoundingMode.DOWN);
    return descontoSalarial.subtract(relacao.getDeducao());
  }

}
