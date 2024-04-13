package com.fag.sistema.domain.repositories;

import com.fag.sistema.domain.entities.Empregado;

import java.util.List;

public interface IEmpregadoVendor {
    List<Empregado> getAllEmpregados();

    Empregado getEmpregadoByCPF(String cpf);
}
