package com.fag.sistema.domain.mappers;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.fag.sistema.domain.dto.ProventosDTO;
import com.fag.sistema.domain.entities.Proventos;
import com.fag.sistema.domain.usecases.calcular.beneficios.AdicionalInsalubridade;
import com.fag.sistema.domain.usecases.calcular.beneficios.AdicionalNoturno;
import com.fag.sistema.domain.usecases.calcular.descontos.INSS;
import com.fag.sistema.domain.usecases.calcular.descontos.IRRF;
import com.fag.sistema.domain.usecases.calcular.descontos.ValeAlimentacao;
import com.fag.sistema.domain.usecases.calcular.descontos.ValeTransporte;

public class ProventosMapperTest {

  private Proventos makeBO() {
    Proventos bo = new Proventos();
    bo.setTotalBeneficios(new BigDecimal("3000"));
    bo.setTotalDescontos(new BigDecimal("3000"));
    bo.setBeneficios(List.of(new AdicionalNoturno(), new AdicionalInsalubridade()));
    bo.setDescontos(List.of(new ValeAlimentacao(), new ValeTransporte()));
    bo.setDescontosEmFolha(List.of(new INSS(), new IRRF()));

    return bo;
  }

  private ProventosDTO makeDTO() {
    ProventosDTO bo = new ProventosDTO();
    bo.setTotalBeneficios(new BigDecimal("3000"));
    bo.setTotalDescontos(new BigDecimal("3000"));
    bo.setBeneficios(List.of(new AdicionalNoturno(), new AdicionalInsalubridade()));
    bo.setDescontos(List.of(new ValeAlimentacao(), new ValeTransporte()));
    bo.setDescontosEmFolha(List.of(new INSS(), new IRRF()));

    return bo;
  }

  @Test
  void shouldMapToBO() {
    ProventosDTO dto = makeDTO();

    Proventos bo = ProventosMapper.toBO(dto);

    assertAll("Proventos", 
    () -> assertEquals(dto.getTotalBeneficios(), bo.getTotalBeneficios()),
    () -> assertEquals(dto.getTotalDescontos(), bo.getTotalDescontos()),
    () -> assertEquals(dto.getBeneficios(), bo.getBeneficios()),
    () -> assertEquals(dto.getDescontos(), bo.getDescontos()),
    () -> assertEquals(dto.getDescontosEmFolha(), bo.getDescontosEmFolha()));
  }

  @Test
  void shouldMapToDTO() {
    Proventos dto = makeBO();

    ProventosDTO bo = ProventosMapper.toDTO(dto);

    assertAll("Proventos", 
    () -> assertEquals(dto.getTotalBeneficios(), bo.getTotalBeneficios()),
    () -> assertEquals(dto.getTotalDescontos(), bo.getTotalDescontos()),
    () -> assertEquals(dto.getBeneficios(), bo.getBeneficios()),
    () -> assertEquals(dto.getDescontos(), bo.getDescontos()),
    () -> assertEquals(dto.getDescontosEmFolha(), bo.getDescontosEmFolha()));
  }
}
