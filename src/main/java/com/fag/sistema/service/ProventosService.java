package com.fag.sistema.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fag.sistema.domain.dto.ProventosDTO;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empresa;
import com.fag.sistema.domain.usecases.calcular.beneficios.IBeneficioUseCase;
import com.fag.sistema.domain.usecases.calcular.descontos.IDescontoEmFolhaUseCase;
import com.fag.sistema.domain.usecases.calcular.descontos.IDescontoUseCase;

@Service
public class ProventosService {
    @Autowired
    private List<IBeneficioUseCase> beneficios;

    @Autowired
    private List<IDescontoUseCase> descontos;

    @Autowired
    private List<IDescontoEmFolhaUseCase> descontosEmFolha;

    public ProventosDTO calcularProventos(Empregado empregado, Empresa empresa) {
        BigDecimal totalBeneficios = BigDecimal.ZERO;
        BigDecimal totalDescontos = BigDecimal.ZERO;

        for (IBeneficioUseCase beneficio : beneficios) {
            totalBeneficios = totalBeneficios.add(beneficio.calculate(empregado, empresa));
        }

        for (IDescontoUseCase desconto : descontos) {
            totalDescontos = totalDescontos.add(desconto.calculate(empregado, empresa));
        }

        for (IDescontoEmFolhaUseCase desconto : descontosEmFolha) {
            totalDescontos = totalDescontos.add(desconto.calculate(empregado, empresa));
        }

        ProventosDTO proventos = new ProventosDTO();
        totalBeneficios = totalBeneficios.add(empregado.getContrato().getSalario().getBruto());
        
        proventos.setBeneficios(beneficios);
        proventos.setDescontos(descontos);
        proventos.setDescontosEmFolha(descontosEmFolha);
        proventos.setTotalBeneficios(totalBeneficios);
        proventos.setTotalDescontos(totalDescontos);

        return proventos;
    }

}
