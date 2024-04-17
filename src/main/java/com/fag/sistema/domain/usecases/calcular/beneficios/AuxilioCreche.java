package com.fag.sistema.domain.usecases.calcular.beneficios;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fag.sistema.domain.entities.Provento;
import com.fag.sistema.domain.entities.empregado.Dependente;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empresa;
import com.fag.sistema.domain.enums.EnumGenero;

@Component
public class AuxilioCreche extends Provento implements IBeneficioUseCase {

  public AuxilioCreche() {
    super("Auxilio Creche");
  }

  @Override
  public BigDecimal calculate(Empregado empregado, Empresa empresa) {
    BigDecimal beneficio = BigDecimal.ZERO.setScale(2, RoundingMode.DOWN);
    BigDecimal referencia = new BigDecimal("0.05");
    List<Empregado> empregadosDoGeneroFeminino = getEmpregadosDoGeneroFeminino(empresa);

    if (!empregado.possuiDependente()) return beneficio;

    if (empregadosDoGeneroFeminino.size() < 30) return beneficio;

    for (Empregado funcionaria : empregadosDoGeneroFeminino) {
      if (!funcionaria.possuiDependente()) return beneficio;

      for (Dependente d : funcionaria.getDependentes()) {
        Boolean estaApto = this.dependenteAptoParaBeneficio(d);

        if (!estaApto) return beneficio;
      }
    }

    List<Dependente> dependentes = empregado.getDependentes();
    BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();

    for (Dependente d : dependentes) {
      Boolean estaApto = this.dependenteAptoParaBeneficio(d);
      if (estaApto) {
        BigDecimal auxilioCreche = salarioBruto.multiply(referencia).setScale(2, RoundingMode.HALF_UP);
        beneficio = beneficio.add(auxilioCreche);
      }
    }

    this.setProvento(getDescricao(), referencia, beneficio, BigDecimal.ZERO);
    empregado.getContrato().getSalario().somarBasesDeCalculo(beneficio);

    return beneficio;
  }

  private List<Empregado> getEmpregadosDoGeneroFeminino(Empresa empresa) {
    List<Empregado> empregados = new ArrayList<Empregado>();

    for (Empregado e : empresa.getEmpregados()) {
      if (e.getGenero() == EnumGenero.FEMININO) {
        empregados.add(e);
      }
    }

    return empregados;
  }

  private Boolean dependenteAptoParaBeneficio(Dependente dependente) {
    LocalDate now = LocalDate.now();
    Long diferencaEmMeses = ChronoUnit.MONTHS.between(dependente.getDataNascimento(), now);
    if (diferencaEmMeses < 6) return true;

    return false;
  }
}
