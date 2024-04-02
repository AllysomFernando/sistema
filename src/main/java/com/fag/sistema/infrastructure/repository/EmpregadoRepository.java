package com.fag.sistema.infrastructure.repository;

import com.fag.sistema.domain.entities.Empregado;
import com.fag.sistema.domain.repositories.IEmpregadoVendor;
import com.fag.sistema.infrastructure.adapters.json.JsonFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpregadoRepository implements IEmpregadoVendor {
    private Map<String, Empregado> empregados = new HashMap<>();

    public EmpregadoRepository(String jsonFilePath){
        JsonFileReader jsonFileReader = new JsonFileReader();
        try{
            List<Empregado> empregadosList = jsonFileReader.readEmpregadoList(jsonFilePath);
            for (Empregado empregado : empregadosList){
                this.empregados.put(empregado.getCpf(), empregado);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public List<Empregado> getAllEmpregados() {
        return new ArrayList<>(empregados.values());
    }
}
