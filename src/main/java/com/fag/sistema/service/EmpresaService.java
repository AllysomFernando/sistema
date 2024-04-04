package com.fag.sistema.service;


import com.fag.sistema.domain.dto.EmpregadorDTO;
import com.fag.sistema.domain.entities.Empregador;
import com.fag.sistema.domain.mappers.EmpregadorMapper;
import com.fag.sistema.infrastructure.repositories.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpresaService {
    private EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public List<EmpregadorDTO> getAllEmpresas() {
        List<Empregador> empresaList = empresaRepository.getAllEmpregador();
        return empresaList.stream()
                .map(EmpregadorMapper::toDTO)
                .collect(Collectors.toList());
    }
}
