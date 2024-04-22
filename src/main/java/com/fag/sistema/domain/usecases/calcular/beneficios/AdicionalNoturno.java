package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

import com.fag.sistema.domain.entities.Provento;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empresa;

@Component
public class AdicionalNoturno extends Provento implements IBeneficioUseCase {

    public AdicionalNoturno() {
        super("Adicional Noturno");
    }

    @Override
    public BigDecimal calculate(Empregado empregado, Empresa empresa) {

        Float horasNoturnas = empregado.getHorario().getHorasAdicionalNoturno();
        BigDecimal valorAdicionalNoturno = new BigDecimal("0");

        if (horasNoturnas > 0) {
            BigDecimal salarioBase = empregado.getContrato().getSalario().getBruto();
            float totalHoraMensais = empresa.getCargaHorariaMensal();

            if (totalHoraMensais > 0 && salarioBase.compareTo(BigDecimal.ZERO) >= 0) {
                BigDecimal porcentagem = new BigDecimal("1.5");

                BigDecimal valorHora = salarioBase.divide(new BigDecimal(totalHoraMensais), 2, RoundingMode.HALF_DOWN);
                valorAdicionalNoturno = valorEmReaisDasHorasExtras(porcentagem, valorHora, new BigDecimal(horasNoturnas, MathContext.DECIMAL128));

                this.setProvento(this.getDescricao(), porcentagem, valorAdicionalNoturno, BigDecimal.ZERO);
                empregado.getContrato().getSalario().somarBasesDeCalculo(valorAdicionalNoturno);
            }
        }

        return valorAdicionalNoturno;
    }

    private BigDecimal valorEmReaisDasHorasExtras(BigDecimal referencia, BigDecimal valorHora, BigDecimal horasFeitas) {
        return valorHora
        .multiply(horasFeitas)
        .multiply(referencia)
        .setScale(2, RoundingMode.DOWN);
    }

}
