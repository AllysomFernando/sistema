package com.fag.sistema.infrastructure.interfaces;

import java.util.List;

public interface IJsonReader<T> {
  public T read();

  public List<T> readListFromJson();

  public T[] readArrayFromJson();
}
