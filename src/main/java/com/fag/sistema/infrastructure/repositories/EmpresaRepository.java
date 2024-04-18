package com.fag.sistema.infrastructure.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empresa;
import com.fag.sistema.domain.enums.EnumGenero;
import com.fag.sistema.domain.repositories.IEmpresaVendor;
import com.fag.sistema.infrastructure.adapters.gson.GsonAdapter;

@Repository
public class EmpresaRepository implements IEmpresaVendor {

    @Autowired
    private GsonAdapter<Empresa> data;

    @Override
    public List<Empresa> getAllEmpregador() {
        return this.data.readListFromJson(Empresa[].class);
    }

    @Override
    public Empresa getEmpresaByCNPJ(String cnpj) {
        Empresa[] empresas = this.getAll();

        for (Empresa empresa : empresas) {
            if (empresa.getCnpj().equals(cnpj))
                return empresa;
        }

        throw new RuntimeException("Empresa com o CNPJ [" + cnpj + "] não foi encontrada");
    }

    @Override
    public Empresa[] getAll() {
        return this.data.readArrayFromJson(Empresa[].class);
    }

    public List<Empregado> getAllFuncionariosMulheresByEmpresaCnpj(String cnpj) {
        Empresa empresa = this.getEmpresaByCNPJ(cnpj);
        List<Empregado> funcionaria = new ArrayList<Empregado>();

        for (Empregado e : empresa.getEmpregados()) {
            if (e.getGenero() == EnumGenero.FEMININO) {
                funcionaria.add(e);
            }
        }

        return funcionaria;
    }

    public List<Empregado> getAllFuncionariasComSalarioMaternidade(String cnpj) {
        Empresa empresa = this.getEmpresaByCNPJ(cnpj);
        List<Empregado> funcionaria = new ArrayList<Empregado>();

        for (Empregado e : empresa.getEmpregados()) {
            if (e.getGenero() == EnumGenero.FEMININO && e.getContrato().getBeneficios().getSalarioMaternidade()) {
                funcionaria.add(e);
            }
        }

        return funcionaria;
    }

    public HashMap<String, List<Empregado>> getAllFuncionariosGroupByCategoria(String cnpj) {
        Empresa empresa = this.getEmpresaByCNPJ(cnpj);
        HashMap<String, List<Empregado>> map = new HashMap<String, List<Empregado>>();

        for (Empregado e : empresa.getEmpregados()) {
            String key = e.getContrato().getTipoContrato().name().toLowerCase();
            if (map.containsKey(key)) {
                map.get(key).add(e);
            } else {
                map.put(key, new ArrayList<Empregado>());
                map.get(key).add(e);
            }
        }

        return map;
    }
}
