package com.fag.sistema.domain.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import com.fag.sistema.domain.entities.Contrato;
import com.fag.sistema.domain.entities.Empregado;
import com.fag.sistema.domain.entities.Horario;
import com.fag.sistema.domain.entities.Salario;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnumBeneficioTest {
    @Test
    @Description("Should calculate Adicional Insalubridade")
    public void shouldCalculateAdicionalInsalubridade() {
        EnumBeneficios enumBeneficios = EnumBeneficios.ADICIONAL_INSALUBRIDADE;

        Empregado colaborador = new Empregado();
        Contrato contrato = new Contrato();
        contrato.setGrauInsalubridade(10);
        contrato.setSalario(new Salario(new BigDecimal("1900.0"), new BigDecimal("1600")));
        colaborador.setContrato(contrato);

        BigDecimal beneficio = enumBeneficios.calculate(colaborador);

        assertEquals(new BigDecimal("190.00"), beneficio);
    }
    @Test
    @Description("Should calculate Hora Extra")
    public void shouldCalculateHoraExtra() {
        EnumBeneficios enumBeneficios = EnumBeneficios.HORA_EXTRA;

        Empregado colaborador = new Empregado();
        Contrato contrato = new Contrato();
        Salario salario = new Salario(new BigDecimal("1900"), new BigDecimal("1600"));
        contrato.setSalario(salario);
        colaborador.setContrato(contrato);

        Horario horario = new Horario(220, 0, false, 10, 10);
        colaborador.setHorario(horario);

        BigDecimal beneficio = enumBeneficios.calculate(colaborador);
        assertEquals(new BigDecimal("95.00"), beneficio);
    }
}
