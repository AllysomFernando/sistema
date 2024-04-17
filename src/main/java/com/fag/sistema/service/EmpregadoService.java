package com.fag.sistema.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fag.sistema.domain.dto.EmpregadoDTO;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empresa;
import com.fag.sistema.domain.mappers.EmpregadoMapper;
import com.fag.sistema.infrastructure.repositories.EmpregadoRepository;
import com.fag.sistema.infrastructure.repositories.EmpresaRepository;

@Service
public class EmpregadoService {

    @Autowired
    private EmpregadoRepository empregadoRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<EmpregadoDTO> getAllEmpregados() {
        List<Empregado> empregadosList = empregadoRepository.getAllEmpregados();
        return empregadosList.stream()
                .map(EmpregadoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Empregado getEmpregadoByCpf(String cpf, List<Empregado> empregados) {

        for (Empregado empregado : empregados) {
            if (empregado.getCpf().equals(cpf)) {
                return empregado;
            }
        }

        throw new RuntimeException("Nenhum funcionário encontrado");
    }

    public Empregado findEmpregadoByCpf(String cpf) {
        List<Empresa> empresas = empresaRepository.getAllEmpregador();

        for (Empresa empresa : empresas) {
            List<Empregado> empregados = empresa.getEmpregados();

            for (Empregado empregado : empregados) {
                if (empregado.getCpf().equals(cpf)) {
                    return empregado;
                }
            }
        }

        throw new RuntimeException("Nenhum funcionário encontrado");
    }
}
