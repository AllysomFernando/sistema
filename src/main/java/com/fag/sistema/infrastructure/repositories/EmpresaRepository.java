package com.fag.sistema.infrastructure.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empregador;
import com.fag.sistema.domain.enums.EnumGenero;
import com.fag.sistema.domain.repositories.IEmpresaVendor;
import com.fag.sistema.infrastructure.adapters.gson.GsonAdapter;

@Repository
public class EmpresaRepository implements IEmpresaVendor {
    
    private GsonAdapter<Empregador> data;

    public EmpresaRepository() {
        this.data = new GsonAdapter<Empregador>("data.json");
    }

    @Override
    public List<Empregador> getAllEmpregador() {
        return this.data.readListFromJson(Empregador[].class);
    }

    @Override
    public Empregador getEmpresaByCNPJ(String cnpj) {
        Empregador[] empresas = this.getAll();

        for (Empregador empresa : empresas) {
            if (empresa.getCnpj().equals(cnpj))
                return empresa;
        }

        throw new RuntimeException("Empresa com o CNPJ [" + cnpj + "] não foi encontrada");
    }

    @Override
    public Empregador[] getAll() {
        return this.data.readArrayFromJson(Empregador[].class);
    }

    public List<Empregado> getAllFuncionariosMulheresByEmpresaCnpj(String cnpj) {
        Empregador empresa = this.getEmpresaByCNPJ(cnpj);
        List<Empregado> funcionaria = new ArrayList<Empregado>();

        for (Empregado e : empresa.getEmpregados()) {
            if (e.getGenero() == EnumGenero.FEMININO) {
                funcionaria.add(e);
            }
        }

        return funcionaria;
    }
}
