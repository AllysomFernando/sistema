package com.fag.sistema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fag.sistema.domain.dto.HoleriteDTO;
import com.fag.sistema.domain.dto.ProventosDTO;
import com.fag.sistema.domain.entities.Holerite;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empresa;
import com.fag.sistema.domain.mappers.HoleriteMapper;
import com.fag.sistema.domain.mappers.ProventosMapper;

@Service
public class HoleriteService {
    @Autowired
    private EmpregadoService empregadoService;

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private ProventosService proventosService;

    public HoleriteDTO criarHolerite(String cpf, String cnpj) {
        Empresa empregador = empresaService.getEmpresaByCnpj(cnpj);
        Empregado empregado = empregadoService.getEmpregadoByCpf(cpf, empregador.getEmpregados());

        ProventosDTO proventos = proventosService.calcularProventos(empregado, empregador);

        Holerite holerite = new Holerite();

        empregado.getContrato().getSalario()
                .setLiquido((empregado.getContrato().getSalario().getBruto().add(proventos.getTotalBeneficios()))
                        .subtract(proventos.getTotalDescontos()));

        holerite.setEmpregado(empregado);
        holerite.setEmpregador(empregador);
        holerite.setProventos(ProventosMapper.toBO(proventos));

        HoleriteDTO holeriteDTO = HoleriteMapper.toDTO(holerite);

        return holeriteDTO;
    }

}
