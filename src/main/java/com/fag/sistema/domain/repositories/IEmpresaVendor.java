package com.fag.sistema.domain.repositories;

import java.util.List;

import com.fag.sistema.domain.entities.empresa.Empresa;

public interface IEmpresaVendor extends IAbstractRepository<Empresa> {
    List<Empresa> getAllEmpregador();

    Empresa getEmpresaByCNPJ(String cnpj);

}
