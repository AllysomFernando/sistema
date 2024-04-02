package com.fag.sistema.infrastructure.adapters.json;

import com.fag.sistema.domain.entities.Empregado;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;

public class JsonFileReader {
    public static void main(String[] args){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try{
            Empregado empregado = objectMapper.readValue(new File("src/java/com/fag/sistema/assets/dados.json"), Empregado.class);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
