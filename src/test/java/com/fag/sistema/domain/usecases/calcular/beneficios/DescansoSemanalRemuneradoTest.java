package com.fag.sistema.domain.usecases.calcular.beneficios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import com.fag.sistema.domain.entities.empregado.Contrato;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empregado.Horario;
import com.fag.sistema.domain.entities.empregado.Salario;
import com.fag.sistema.domain.entities.empresa.Empresa;

public class DescansoSemanalRemuneradoTest {
    
    private Empregado makeEmpregado(BigDecimal salarioBruto, int horaTrabalhada) {
        Empregado empregado = new Empregado();
        Horario horario = new Horario();
        Contrato contrato = new Contrato();
        Salario salario = new Salario(salarioBruto);

        contrato.setSalario(salario);
        
        empregado.setContrato(contrato);
        empregado.setHorario(horario);
    
        return empregado;
      }
    
      private Empresa makeEmpresa(Float cargaHorariaDiaria) {
        Empresa empresa = new Empresa();
        empresa.setCargaHorariaDiaria(cargaHorariaDiaria);
    
        return empresa;
      }

    @Test
    @Description("Retorna o valor R$150,00")
    void shouldNotUpdateBaseDeCalculos() {
    DescansoSemanalRemunerado sut = new DescansoSemanalRemunerado();
    Empregado empregado = makeEmpregado(new BigDecimal("3000"), 168);
    Empresa empresa = makeEmpresa(8.4f);

    BigDecimal result = sut.calculate(empregado, empresa);

    assertEquals(new BigDecimal("150.00"), result);
  }
}
