package com.fag.sistema.infrastructure.repositories;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import com.fag.sistema.domain.entities.Empregador;
import com.fag.sistema.domain.repositories.IEmpresaVendor;
import com.fag.sistema.infrastructure.adapters.json.JsonFileReader;

@Repository
public class EmpresaRepository implements IEmpresaVendor {
    private Map<String, Empregador> empresas = new HashMap<>();
    private JsonFileReader mapper;

    public EmpresaRepository(JsonFileReader jsonFileReader,  @Value("${empregador.json.path}") String jsonFilePath) {
        this.mapper = jsonFileReader;
        try {
            Resource resource = new ClassPathResource(jsonFilePath);
            try (InputStream inputStream = resource.getInputStream()) {
                List<Empregador> empresaList = mapper.readEmpresaList(inputStream);
                for (Empregador empresa : empresaList) {
                    this.empresas.put(empresa.getCNPJ(), empresa);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar arquivo JSON", e);
        }
    }

    @Override
    public List<Empregador> getAllEmpregador() {
        return new ArrayList<>(empresas.values());
    }
    @Override
    public Empregador getEmpresaByCNPJ(String cnpj) {
        return empresas.get(cnpj);
    }
    @Override
    public void addAllEmpresas(List<Empregador> empresaList) {
        for (Empregador empresa : empresaList) {
            this.empresas.put(empresa.getCNPJ(), empresa);
        }
    }
}
