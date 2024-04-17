package com.fag.sistema.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empresa;
import com.fag.sistema.infrastructure.repositories.EmpresaRepository;

@Service
public class EmpregadoService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Empregado> getAllEmpregados() {
        List<Empresa> empresas = empresaRepository.getAllEmpregador();
        List<Empregado> empregados = new ArrayList<Empregado>();

        for (Empresa empresa : empresas) {
            for (Empregado empregado : empresa.getEmpregados()) {
                empregados.add(empregado);
            }
        }

        return empregados;
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
