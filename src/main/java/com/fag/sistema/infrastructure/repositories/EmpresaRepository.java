package com.fag.sistema.infrastructure.repositories;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fag.sistema.domain.entities.Empregador;
import com.fag.sistema.domain.repositories.IEmpresaVendor;
import com.fag.sistema.infrastructure.adapters.gson.GsonAdapter;

@Repository
public class EmpresaRepository implements IEmpresaVendor {
    private Map<String, Empregador> empresas = new HashMap<>();
    private GsonAdapter<Empregador> data = new GsonAdapter<Empregador>("data.json");

    @Override
    public List<Empregador> getAllEmpregador() {
        return this.data.readListFromJson(Empregador[].class);
    }
    
    @Override
    public Empregador getEmpresaByCNPJ(String cnpj) {
        return empresas.get(cnpj);
    }

    @Override
    public Empregador[] getAll() {
        return this.data.readArrayFromJson(Empregador[].class);
    }
}
