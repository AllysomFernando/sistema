package com.fag.sistema.domain.repositories;

import com.fag.sistema.domain.entities.Empregador;

import java.util.List;

public interface IEmpresaVendor {
    List<Empregador> getAllEmpregador();

    Empregador getEmpresaByCNPJ(String cnpj);

    void addAllEmpresas(List<Empregador> empresaList);

}
