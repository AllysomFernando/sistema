package com.fag.sistema.service;


import com.fag.sistema.domain.dto.EmpregadoDTO;
import com.fag.sistema.domain.entities.Empregado;
import com.fag.sistema.domain.mappers.EmpregadoMapper;
import com.fag.sistema.infrastructure.repositories.EmpregadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpregadoService {
    private EmpregadoRepository empregadoRepository;

    public EmpregadoService(EmpregadoRepository empregadoRepository) {
        this.empregadoRepository = empregadoRepository;
    }

    public List<EmpregadoDTO> getAllEmpregados() {
        List<Empregado> empregadosList = empregadoRepository.getAllEmpregados();
        return empregadosList.stream()
                .map(EmpregadoMapper::toDTO)
                .collect(Collectors.toList());
    }
}
