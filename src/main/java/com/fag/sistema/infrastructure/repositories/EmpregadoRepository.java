package com.fag.sistema.infrastructure.repositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fag.sistema.domain.entities.Empregado;
import com.fag.sistema.domain.repositories.IEmpregadoVendor;
import com.fag.sistema.infrastructure.adapters.json.JsonFileReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmpregadoRepository implements IEmpregadoVendor {
    private static final Logger log = LoggerFactory.getLogger(EmpregadoRepository.class);
    private Map<String, Empregado> empregados = new HashMap<>();
    private JsonFileReader mapper;

    public EmpregadoRepository(JsonFileReader jsonFileReader, @Value("${empregado.json.path}") String jsonFilePath) {
        this.mapper = jsonFileReader;
        try {
            Resource resource = new ClassPathResource(jsonFilePath);
            try (InputStream inputStream = resource.getInputStream()) {
                List<Empregado> empregadosList = mapper.readEmpregadoList(inputStream);
                for (Empregado empregado : empregadosList) {
                    this.empregados.put(empregado.getCPF(), empregado);
                }
            }
        } catch (IOException e) {
            log.error("Erro ao ler o arquivo JSON", e);
            throw new RuntimeException("Erro ao ler o arquivo JSON", e);
        }
    }

    @Override
    public List<Empregado> getAllEmpregados() {
        return new ArrayList<>(empregados.values());
    }

    @Override
    public void addAllEmpregados(List<Empregado> empregadoList) {
        for (Empregado empregado : empregadoList) {
            this.empregados.put(empregado.getCPF(), empregado);
        }
    }
}