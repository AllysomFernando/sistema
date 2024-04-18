package com.fag.sistema.infrastructure.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empresa;
import com.fag.sistema.domain.repositories.IEmpregadoVendor;
import com.fag.sistema.infrastructure.adapters.gson.GsonAdapter;

@Repository
public class EmpregadoRepository implements IEmpregadoVendor {

    @Autowired
    private GsonAdapter<Empresa> data;

    @Override
    public List<Empregado> getAllEmpregados() {
        List<Empresa> list = this.data.readListFromJson(Empresa[].class);
        List<Empregado> empregados = new ArrayList<Empregado>();

        for (Empresa empresa : list) {
            for (Empregado empregado : empresa.getEmpregados()) {
                empregados.add(empregado);
            }
        }

        return empregados;
    }

    @Override
    public Empregado getEmpregadoByCPF(String cpf) {
        List<Empresa> result = this.data.readListFromJson(Empresa[].class);

        for (Empresa empresa : result) {
            for (Empregado empregado : empresa.getEmpregados()) {
                if (empregado.getCpf().equals(cpf)) {
                    return empregado;
                }
            }
        }

        throw new RuntimeException("Empregado não encontrado");
    }

}
