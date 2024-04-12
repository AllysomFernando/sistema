package com.fag.sistema.service;
import com.fag.sistema.domain.entities.Holerite;
import com.fag.sistema.domain.mappers.HoleriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fag.sistema.domain.dto.HoleriteDTO;
import com.fag.sistema.domain.entities.Empregado;
import com.fag.sistema.domain.entities.Empregador;
import com.fag.sistema.domain.entities.Proventos;
import com.fag.sistema.infrastructure.repositories.EmpregadoRepository;
import com.fag.sistema.infrastructure.repositories.EmpresaRepository;

@Service
public class HoleriteService {
    @Autowired
    private EmpregadoRepository empregadoRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private ProventosService proventosService;

    public HoleriteDTO criarHolerite(String cpf, String cnpj){
        Empregado empregado = empregadoRepository.getEmpregadoByCPF(cpf);
        Empregador empregador = empresaRepository.getEmpresaByCNPJ(cnpj);

        Proventos proventos = proventosService.calcularProventos(empregado);
        Holerite holerite = new Holerite();
        holerite.setEmpregado(empregado);
        holerite.setEmpregador(empregador);
        holerite.setProventos(proventos);

        HoleriteDTO holeriteDTO = HoleriteMapper.toDTO(holerite);

        return holeriteDTO;
    }


}
