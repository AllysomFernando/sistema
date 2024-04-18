package com.fag.sistema.service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fag.sistema.domain.dto.EmpregadorDTO;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empresa;
import com.fag.sistema.domain.mappers.EmpresaMapper;
import com.fag.sistema.infrastructure.repositories.EmpresaRepository;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    public List<EmpregadorDTO> getAllEmpresas() {
        List<Empresa> empresaList = empresaRepository.getAllEmpregador();
        return empresaList.stream()
                .map(EmpresaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Empresa getEmpresaByCnpj(String cnpj) {
        Empresa empregador = empresaRepository.getEmpresaByCNPJ(cnpj);
        if (empregador != null) {
            List<Empregado> funcionariasComSalarioMaternidade = empresaRepository
                    .getAllFuncionariasComSalarioMaternidade(cnpj);
            HashMap<String, List<Empregado>> funcionariosAgrupados = empresaRepository
                    .getAllFuncionariosGroupByCategoria(cnpj);
            empregador.setFuncionariasComSalarioMaternidade(funcionariasComSalarioMaternidade);
            empregador.setFuncionariosAgrupados(funcionariosAgrupados);
            return empregador;
        }
        return null;
    }
}
