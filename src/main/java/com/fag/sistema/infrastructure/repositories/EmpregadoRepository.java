package com.fag.sistema.infrastructure.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fag.sistema.domain.entities.Empregado;
import com.fag.sistema.domain.repositories.IEmpregadoVendor;
import com.fag.sistema.infrastructure.adapters.gson.GsonAdapter;

@Repository
public class EmpregadoRepository implements IEmpregadoVendor {
    private Map<String, Empregado> empregados = new HashMap<>();
    private GsonAdapter<Empregado> data;

    public EmpregadoRepository() {
        this.data = new GsonAdapter<Empregado>("empregado.json");
    }

    @Override
    public List<Empregado> getAllEmpregados() {
        return this.data.readListFromJson(Empregado[].class);
    }

    @Override
    public Empregado getEmpregadoByCPF(String cpf) {
        return empregados.get(cpf);
    }

    @Override
    public void addAllEmpregados(List<Empregado> empregadoList) {
        for (Empregado empregado : empregadoList) {
            this.empregados.put(empregado.getCpf(), empregado);
        }
    }
}
