package com.fag.sistema.domain.enums;

import java.time.LocalTime;

public enum EnumHorarioTrabalho {
  COMERCIAL(LocalTime.of(8, 0), LocalTime.of(18, 0)),
  NOTURNO(LocalTime.of(22, 0), LocalTime.of(5, 0));

  private LocalTime horarioInicio;
  private LocalTime horarioTermino;

  EnumHorarioTrabalho(LocalTime horarioInicio, LocalTime horarioTermino) {
    this.horarioInicio = horarioInicio;
    this.horarioTermino = horarioTermino;
  }

  public LocalTime getHorarioInicio() {
    return horarioInicio;
  }

  public LocalTime getHorarioTermino() {
    return horarioTermino;
  }
}
