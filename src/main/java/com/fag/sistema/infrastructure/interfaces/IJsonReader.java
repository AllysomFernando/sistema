package com.fag.sistema.infrastructure.interfaces;

import java.util.List;

public interface IJsonReader<T> {
  public T readObjectFromJson(Class<T> clazz);

  public List<T> readListFromJson(Class<T[]> clazz);

  public T[] readArrayFromJson();
}
