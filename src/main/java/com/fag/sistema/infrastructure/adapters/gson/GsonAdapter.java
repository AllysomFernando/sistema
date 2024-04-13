package com.fag.sistema.infrastructure.adapters.gson;

import java.io.FileReader;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.file.FileSystems;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fag.sistema.infrastructure.interfaces.IJsonReader;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

@Component
public class GsonAdapter<T> implements IJsonReader<T> {

  private Gson gson;
  private Type listType = new TypeToken<List<T>>() {
  }.getType();

  private String fileName;

  public GsonAdapter(String fileName) {
    this.gson = new Gson();
    this.fileName = fileName;
  }

  @Override
  public T read() {
    InputStream resource = this.getClass().getClassLoader().getResourceAsStream("empregado.json");
    if (resource == null) {
      throw new RuntimeException("Arquivo não encontrado no diretório");
    }

    List<T> data = Collections.singletonList(gson.fromJson(resource.toString(), listType));
    return null;
  }

  @Override
  public List<T> readListFromJson() {
    JsonReader reader = new JsonReader(this.getResource());

    List<T> data = gson.fromJson(reader, this.listType);
    return data;
  }

  @Override
  public T[] readArrayFromJson() {
    JsonReader reader = new JsonReader(this.getResource());

    T[] data = gson.fromJson(reader, this.listType);
    return data;
  }

  public FileReader getResource() {
    String filePath = FileSystems.getDefault().getPath("src/main/resources/" + this.fileName).toAbsolutePath()
        .toString();
    try {
      FileReader file = new FileReader(filePath);
      return file;
    } catch (Exception e) {
      throw new RuntimeException("Arquivo não encontrado");
    }
  }

}
