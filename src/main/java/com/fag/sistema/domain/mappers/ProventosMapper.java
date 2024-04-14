package com.fag.sistema.domain.mappers;

import com.fag.sistema.domain.dto.ProventosDTO;
import com.fag.sistema.domain.entities.Proventos;

public class ProventosMapper {

  public static ProventosDTO toDTO(Proventos bo) {
    ProventosDTO proventos = new ProventosDTO();
    proventos.setBeneficios(bo.getBeneficios());
    proventos.setDescontos(bo.getDescontos());
    proventos.setTotalBeneficios(bo.getTotalBeneficios());
    proventos.setTotalDescontos(bo.getTotalDescontos());

    return proventos;
  }

  public static Proventos toBO(ProventosDTO dto) {
    Proventos proventos = new Proventos();
    proventos.setBeneficios(dto.getBeneficios());
    proventos.setDescontos(dto.getDescontos());
    proventos.setTotalBeneficios(dto.getTotalBeneficios());
    proventos.setTotalDescontos(dto.getTotalDescontos());

    return proventos;
  }

}
