package com.fag.sistema.infrastructure.adapters.json;

import com.fag.sistema.domain.entities.Empregado;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonFileReader {
    private ObjectMapper objectMapper;

    public JsonFileReader() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    public List<Empregado> readEmpregadoList(String jsonFilePath) throws IOException {
        return objectMapper.readValue(new File(jsonFilePath), new TypeReference<List<Empregado>>() {
        });
    }
}
