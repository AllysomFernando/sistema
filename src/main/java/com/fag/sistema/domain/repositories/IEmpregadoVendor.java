package com.fag.sistema.domain.repositories;

import java.util.List;

import com.fag.sistema.domain.entities.empregado.Empregado;

public interface IEmpregadoVendor {
    List<Empregado> getAllEmpregados();

    Empregado getEmpregadoByCPF(String cpf);
}
