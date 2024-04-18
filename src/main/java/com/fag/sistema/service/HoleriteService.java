package com.fag.sistema.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fag.sistema.domain.dto.ProventosDTO;
import com.fag.sistema.domain.entities.Holerite;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empresa;
import com.fag.sistema.domain.mappers.ProventosMapper;

@Service
public class HoleriteService {
    @Autowired
    private EmpregadoService empregadoService;

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private ProventosService proventosService;

    public Holerite criarHolerite(String cpf, String cnpj) {
        Empresa empregador = empresaService.getEmpresaByCnpj(cnpj);
        Empregado empregado = empregadoService.findEmpregadoByCpf(cpf);
        BigDecimal salarioBruto = empregado.getContrato().getSalario().getBruto();

        empregado.getContrato().getSalario().setBaseCalculoFGTS(salarioBruto);
        empregado.getContrato().getSalario().setBaseCalculoIrrf(salarioBruto);
        empregado.getContrato().getSalario().setBaseCalculoInss(salarioBruto);

        ProventosDTO proventos = proventosService.calcularProventos(empregado, empregador);

        Holerite holerite = new Holerite();

        BigDecimal salarioLiquido = empregado.getContrato().getSalario().getBruto().add(proventos.getTotalBeneficios());

        BigDecimal salarioLiquidoDescontado = salarioLiquido.subtract(proventos.getTotalDescontos());

        empregado.getContrato().getSalario()
                .setLiquido(salarioLiquidoDescontado);

        holerite.setEmpregado(empregado);
        holerite.setEmpregador(empregador);
        holerite.setProventos(ProventosMapper.toBO(proventos));
        holerite.setBaseCalculoFgts(empregado.getContrato().getSalario().getBaseCalculoFGTS());
        holerite.setBaseCalculoIrrf(empregado.getContrato().getSalario().getBaseCalculoIRRF());
        holerite.setSalarioContribuicaoInss(empregado.getContrato().getSalario().getBaseCalculoInss());
        holerite.setFgtsMensal(empregado.getContrato().getSalario().getFgtsMensal());

        empregado = null;
        proventos = null;
        empregador = null;

        return holerite;
    }

}
