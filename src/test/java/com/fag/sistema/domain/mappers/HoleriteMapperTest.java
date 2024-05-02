package com.fag.sistema.domain.mappers;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.fag.sistema.domain.dto.HoleriteDTO;
import com.fag.sistema.domain.dto.ProventosDTO;
import com.fag.sistema.domain.entities.Holerite;
import com.fag.sistema.domain.entities.Proventos;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empresa;

public class HoleriteMapperTest {
  
  private Holerite makeBO() {
    Holerite bo = new Holerite();
    Proventos proventos = new Proventos();
    proventos.setTotalBeneficios(new BigDecimal("3000"));
    proventos.setTotalDescontos(new BigDecimal("3000"));

    bo.setBaseCalculoFgts(new BigDecimal("3000"));
    bo.setBaseCalculoIrrf(new BigDecimal("3000"));
    bo.setSalarioContribuicaoInss(new BigDecimal("3000"));
    bo.setEmpregado(new Empregado());
    bo.setEmpregador(new Empresa());
    bo.setProventos(proventos);

    return bo;
  }

  private HoleriteDTO makeDTO() {
    HoleriteDTO bo = new HoleriteDTO();
    ProventosDTO proventos = new ProventosDTO();
    proventos.setTotalBeneficios(new BigDecimal("3000"));
    proventos.setTotalDescontos(new BigDecimal("3000"));

    bo.setBaseCalculoFgts(new BigDecimal("3000"));
    bo.setBaseCalculoIrrf(new BigDecimal("3000"));
    bo.setSalarioContribuicaoInss(new BigDecimal("3000"));
    bo.setEmpregado(new Empregado());
    bo.setEmpregador(new Empresa());
    bo.setProventos(proventos);

    return bo;
  }

  @Test
  void shouldMapToBO() {
    Holerite bo = makeBO();

    HoleriteDTO dto = HoleriteMapper.toDTO(bo);

    assertAll("Holerite", 
    () -> assertEquals(bo.getBaseCalculoFgts(), dto.getBaseCalculoFgts()),
    () -> assertEquals(bo.getBaseCalculoIrrf(), dto.getBaseCalculoIrrf()),
    () -> assertEquals(bo.getSalarioContribuicaoInss(), dto.getSalarioContribuicaoInss()),
    () -> assertEquals(bo.getEmpregado(), dto.getEmpregado()),
    () -> assertEquals(bo.getEmpregador(), dto.getEmpregador()),
    () -> assertEquals(bo.getProventos().getTotalBeneficios(), dto.getProventos().getTotalBeneficios()));
  }


  @Test
  void shouldMapToDTO() {
    HoleriteDTO dto = makeDTO();

    Holerite sut = HoleriteMapper.toBO(dto);

    assertAll("Holerite", 
    () -> assertEquals(dto.getBaseCalculoFgts(), sut.getBaseCalculoFgts()),
    () -> assertEquals(dto.getBaseCalculoIrrf(), sut.getBaseCalculoIrrf()),
    () -> assertEquals(dto.getSalarioContribuicaoInss(), sut.getSalarioContribuicaoInss()),
    () -> assertEquals(dto.getEmpregado(), sut.getEmpregado()),
    () -> assertEquals(dto.getEmpregador(), sut.getEmpregador()),
    () -> assertEquals(dto.getProventos().getTotalBeneficios(), sut.getProventos().getTotalBeneficios()));
  }


}
