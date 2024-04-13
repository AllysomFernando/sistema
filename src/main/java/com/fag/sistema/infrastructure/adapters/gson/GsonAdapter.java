package com.fag.sistema.infrastructure.adapters.gson;

import java.io.FileReader;
import java.nio.file.FileSystems;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.fag.sistema.infrastructure.adapters.gson.typeAdapters.LocalDateTypeAdapter;
import com.fag.sistema.infrastructure.interfaces.IJsonReader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

public class GsonAdapter<T> implements IJsonReader<T> {

  private Gson gson;

  private String fileName;

  public GsonAdapter(String fileName) {
    this.gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).create();
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
  public T[] readArrayFromJson(Class<T[]> clazz) {
    JsonReader reader = new JsonReader(this.getResource());

    T[] data = gson.fromJson(reader, clazz);
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
