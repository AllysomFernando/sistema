package com.fag.sistema.service;
import com.fag.sistema.domain.entities.Holerite;
import com.fag.sistema.domain.mappers.HoleriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fag.sistema.domain.dto.EmpregadoDTO;
import com.fag.sistema.domain.dto.EmpregadorDTO;
import com.fag.sistema.domain.dto.HoleriteDTO;
import com.fag.sistema.domain.dto.ProventosDTO;
import com.fag.sistema.domain.entities.Provento;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empregador;
import com.fag.sistema.infrastructure.repositories.EmpregadoRepository;
import com.fag.sistema.infrastructure.repositories.EmpresaRepository;

@Service
public class HoleriteService {
    @Autowired
    private EmpregadoService empregadoService;

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private ProventosService proventosService;

    public HoleriteDTO criarHolerite(String cpf, String cnpj){
        EmpregadoDTO empregado = empregadoService.getEmpregadoByCpf(cpf);
        EmpregadorDTO empregador = empresaService.getEmpresaByCNPJ(cnpj);

        ProventosDTO proventos = proventosService.calcularProventos(empregado);

        Holerite holerite = new Holerite();
        holerite.setEmpregado(empregado);
        holerite.setEmpregador(empregador);
        holerite.setProventos(proventos);

        HoleriteDTO holeriteDTO = HoleriteMapper.toDTO(holerite);

        return holeriteDTO;
    }


}
