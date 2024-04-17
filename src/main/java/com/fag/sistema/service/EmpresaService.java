package com.fag.sistema.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fag.sistema.domain.dto.EmpregadorDTO;
import com.fag.sistema.domain.entities.empresa.Empresa;
import com.fag.sistema.domain.mappers.EmpregadorMapper;
import com.fag.sistema.infrastructure.repositories.EmpresaRepository;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    public List<EmpregadorDTO> getAllEmpresas() {
        List<Empresa> empresaList = empresaRepository.getAllEmpregador();
        return empresaList.stream()
                .map(EmpregadorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public EmpregadorDTO getEmpresaByCNPJ(String cnpj) {
        Empresa empregador = empresaRepository.getEmpresaByCNPJ(cnpj);
        if (empregador != null) {
            return EmpregadorMapper.toDTO(empregador);
        }
        return null;
    }
}
