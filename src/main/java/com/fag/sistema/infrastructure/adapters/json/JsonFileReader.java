package com.fag.sistema.infrastructure.adapters.json;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empresa;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Component
public class JsonFileReader {
    private ObjectMapper objectMapper;

    public JsonFileReader() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    public List<Empregado> readEmpregadoList(InputStream inputStream) throws IOException {
       return objectMapper.readValue(inputStream, new TypeReference<List<Empregado>>() {
       });
    }
    public List<Empresa> readEmpresaList(InputStream inputStream) throws IOException {
        return objectMapper.readValue(inputStream, new TypeReference<List<Empresa>>() {
        });
    }
}
