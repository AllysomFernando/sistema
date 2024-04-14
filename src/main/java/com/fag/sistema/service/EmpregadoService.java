package com.fag.sistema.service;


import com.fag.sistema.domain.dto.EmpregadoDTO;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.mappers.EmpregadoMapper;
import com.fag.sistema.infrastructure.repositories.EmpregadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpregadoService {
    
    @Autowired
    private EmpregadoRepository empregadoRepository;

    public List<EmpregadoDTO> getAllEmpregados() {
        List<Empregado> empregadosList = empregadoRepository.getAllEmpregados();
        return empregadosList.stream()
                .map(EmpregadoMapper::toDTO)
                .collect(Collectors.toList());
    }
    
    public EmpregadoDTO getEmpregadoByCpf(String cpf) {
        Empregado empregado = empregadoRepository.getEmpregadoByCPF(cpf);
        if(empregado != null){
            return EmpregadoMapper.toDTO(empregado);
        }else{
            return null;
        }
    }
}
