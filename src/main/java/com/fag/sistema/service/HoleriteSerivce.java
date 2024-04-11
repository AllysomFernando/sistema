package com.fag.sistema.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fag.sistema.domain.dto.HoleriteDTO;
import com.fag.sistema.domain.entities.Empregado;
import com.fag.sistema.domain.entities.Empregador;
import com.fag.sistema.domain.entities.Proventos;
import com.fag.sistema.infrastructure.repositories.EmpregadoRepository;
import com.fag.sistema.infrastructure.repositories.EmpresaRepository;

@Service
public class HoleriteSerivce {
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

        HoleriteDTO holerite = new HoleriteDTO();
        holerite.setEmpregado(empregado);
        holerite.setEmpregador(empregador);
        holerite.setProventos(proventos);

        return holerite;
    }

}
