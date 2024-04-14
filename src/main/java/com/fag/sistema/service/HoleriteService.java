package com.fag.sistema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fag.sistema.domain.dto.EmpregadoDTO;
import com.fag.sistema.domain.dto.EmpregadorDTO;
import com.fag.sistema.domain.dto.HoleriteDTO;
import com.fag.sistema.domain.dto.ProventosDTO;
import com.fag.sistema.domain.entities.Holerite;
import com.fag.sistema.domain.mappers.EmpregadoMapper;
import com.fag.sistema.domain.mappers.EmpregadorMapper;
import com.fag.sistema.domain.mappers.HoleriteMapper;

@Service
public class HoleriteService {
    @Autowired
    private EmpregadoService empregadoService;

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private ProventosService proventosService;

    public HoleriteDTO criarHolerite(String cpf, String cnpj) {
        EmpregadoDTO empregado = empregadoService.getEmpregadoByCpf(cpf);
        EmpregadorDTO empregador = empresaService.getEmpresaByCNPJ(cnpj);

        ProventosDTO proventos = proventosService.calcularProventos(EmpregadoMapper.toBO(empregado));

        Holerite holerite = new Holerite();

        empregado.getContrato().getSalario()
                .setLiquido((empregado.getContrato().getSalario().getBruto().add(proventos.getTotalBeneficios()))
                        .subtract(proventos.getTotalDescontos()));

        holerite.setEmpregado(EmpregadoMapper.toBO(empregado));
        holerite.setEmpregador(EmpregadorMapper.toBO(empregador));
        holerite.setProventos(proventos);

        HoleriteDTO holeriteDTO = HoleriteMapper.toDTO(holerite);

        return holeriteDTO;
    }

}
