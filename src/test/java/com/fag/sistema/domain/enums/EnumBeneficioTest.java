package com.fag.sistema.domain.enums;

import com.fag.sistema.domain.Contrato;
import com.fag.sistema.domain.Empregado;
import com.fag.sistema.domain.Salario;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import java.math.BigDecimal;

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
}
