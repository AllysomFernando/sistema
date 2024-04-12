package com.fag.sistema.infrastructure.adapters.gson;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fag.sistema.domain.entities.Empregador;
import com.fag.sistema.infrastructure.interfaces.IJsonReader;
import com.google.gson.Gson;

@Component
public class GsonAdapter implements IJsonReader {

  private Gson gson;

  public GsonAdapter() {
    this.gson = new Gson();
  }
  @Override
  public List<Empregador> read() {
    InputStream resource = this.getClass().getClassLoader().getResourceAsStream("empregado.json");
    if (resource == null) {
      throw new RuntimeException("Arquivo não encontrado no diretório");
    }
    List<Empregador> data = Collections.singletonList(gson.fromJson(resource.toString(), Empregador.class));
    return data;
  }

}
