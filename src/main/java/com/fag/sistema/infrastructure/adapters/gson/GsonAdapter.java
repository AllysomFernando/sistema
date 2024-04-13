package com.fag.sistema.infrastructure.adapters.gson;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.nio.file.FileSystems;
import java.util.Arrays;
import java.util.List;

import com.fag.sistema.infrastructure.interfaces.IJsonReader;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

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
  public T readObjectFromJson(Class<T> clazz) {
    JsonReader reader = new JsonReader(this.getResource());

    T data = gson.fromJson(reader, clazz);
    return data;
  }

  @Override
  public List<T> readListFromJson(Class<T[]> clazz) {
    JsonReader reader = new JsonReader(this.getResource());

    T[] data = gson.fromJson(reader, clazz);

    return Arrays.asList(data);
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
