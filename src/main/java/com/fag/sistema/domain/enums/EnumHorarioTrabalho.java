package com.fag.sistema.domain.enums;

public enum EnumHorarioTrabalho {
  COMERCIAL(8, 18),
  NOTURNO(19, 4);

  private int horarioInicio;
  private int horarioTermino;

  EnumHorarioTrabalho(int horarioInicio, int horarioTermino) {
    this.horarioInicio = horarioInicio;
    this.horarioTermino = horarioTermino;
  }

  public int getHorarioInicio() {
    return horarioInicio;
  }

  public int getHorarioTermino() {
    return horarioTermino;
  }
}
