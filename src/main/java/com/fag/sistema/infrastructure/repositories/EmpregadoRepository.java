package com.fag.sistema.infrastructure.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.repositories.IEmpregadoVendor;
import com.fag.sistema.infrastructure.adapters.gson.GsonAdapter;

@Repository
public class EmpregadoRepository implements IEmpregadoVendor {

    @Autowired
    private GsonAdapter<Empregado> data;

    @Override
    public List<Empregado> getAllEmpregados() {
        return this.data.readListFromJson(Empregado[].class);
    }

    @Override
    public Empregado getEmpregadoByCPF(String cpf) {
        List<Empregado> result = this.data.readListFromJson(Empregado[].class);

        for (Empregado empregado : result) {
            if (empregado.getCpf().equals(cpf)) {
                return empregado;
            }
        }

        throw new RuntimeException("Empregado não encontrado");
    }

}
