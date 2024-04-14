package com.fag.sistema.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fag.sistema.domain.dto.ProventosDTO;
import com.fag.sistema.domain.entities.Provento;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.usecases.calcular.beneficios.IBeneficioUseCase;
import com.fag.sistema.domain.usecases.calcular.descontos.IDescontoUseCase;

@Service
public class ProventosService {
    private BigDecimal totalBeneficios;
    private BigDecimal totalDescontos;

    @Autowired
    private List<IBeneficioUseCase> beneficios;

    @Autowired
    private List<IDescontoUseCase> descontos;

    @Autowired
    private List<? extends Provento> proventos;

    public ProventosService() {
        this.totalBeneficios = BigDecimal.ZERO;
        this.totalDescontos = BigDecimal.ZERO;
    }

    public ProventosDTO calcularProventos(Empregado empregado){

        for (IBeneficioUseCase beneficio : beneficios) {
            this.totalBeneficios.add(beneficio.calculate(empregado));
        }

        for (IDescontoUseCase desconto : descontos) {
            this.totalDescontos.add(desconto.calculate(empregado));
        }

        ProventosDTO proventos = new ProventosDTO();
        proventos.setBeneficios(beneficios);
        proventos.setDescontos(descontos);
        proventos.setTotalBeneficios(totalBeneficios);
        proventos.setTotalDescontos(totalDescontos);

        return proventos;
    }

}
