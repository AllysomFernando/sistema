package com.fag.sistema.domain.repositories;

import com.fag.sistema.domain.entities.Empregado;

import java.util.List;
import java.util.Optional;

public interface IEmpregadoVendor {
    List<Empregado> getAllEmpregados();

    void addAllEmpregados(List<Empregado> empregadoList);
}
