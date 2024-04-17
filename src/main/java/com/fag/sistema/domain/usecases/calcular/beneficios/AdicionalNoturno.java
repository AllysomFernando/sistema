package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;
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
            BigDecimal salarioBase = empregado.getContrato().getSalario().getBase();
            float totalHoraMensais = empregado.getHorario().getHoraTrabalhada();

            // Certifique-se de que totalHoraMensais e salarioBase são maiores que 0
            if (totalHoraMensais > 0 && salarioBase.compareTo(BigDecimal.ZERO) > 0) {
                BigDecimal porcentagem = new BigDecimal("1.15");

                BigDecimal valorHora = salarioBase.divide(new BigDecimal(totalHoraMensais), RoundingMode.HALF_UP);
                valorAdicionalNoturno = valorHora
                        .multiply(porcentagem)
                        .subtract(valorHora)
                        .multiply(new BigDecimal(horasNoturnas))
                        .setScale(2, RoundingMode.DOWN);

                this.setProvento(this.getDescricao(), porcentagem, valorAdicionalNoturno, BigDecimal.ZERO);
            }
        }

        empregado.getContrato().getSalario().somarBasesDeCalculo(valorAdicionalNoturno);

        return valorAdicionalNoturno;
    }

}
