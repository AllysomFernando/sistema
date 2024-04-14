package com.fag.sistema.domain.repositories;

import java.util.List;

import com.fag.sistema.domain.entities.empresa.Empregador;

public interface IEmpresaVendor extends IAbstractRepository<Empregador> {
    List<Empregador> getAllEmpregador();

    Empregador getEmpresaByCNPJ(String cnpj);

}
