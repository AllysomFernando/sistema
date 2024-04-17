package com.fag.sistema.infrastructure.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empresa;
import com.fag.sistema.domain.enums.EnumGenero;
import com.fag.sistema.domain.repositories.IEmpresaVendor;
import com.fag.sistema.infrastructure.adapters.gson.GsonAdapter;

@Repository
public class EmpresaRepository implements IEmpresaVendor {
    
    private GsonAdapter<Empresa> data;

    public EmpresaRepository() {
        this.data = new GsonAdapter<Empresa>("data.json");
    }

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
}
