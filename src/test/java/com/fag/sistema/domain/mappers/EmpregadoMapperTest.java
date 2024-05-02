package com.fag.sistema.domain.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.fag.sistema.domain.dto.EmpregadoDTO;
import com.fag.sistema.domain.entities.empregado.Contrato;
import com.fag.sistema.domain.entities.empregado.Dependente;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empregado.Horario;
import com.fag.sistema.domain.enums.EnumGenero;

public class EmpregadoMapperTest {

  private EmpregadoDTO makeDto() {
    EmpregadoDTO dto = new EmpregadoDTO();
    Horario horario = new Horario();
    Contrato contrato = new Contrato();

    dto.setNome("Maude Lucas");
    dto.setGenero(EnumGenero.FEMININO);
    dto.setCpf("1234567890");
    dto.setDataNascimento(LocalDate.now());
    dto.setDependentes(List.of(
        new Dependente("Peter Simpson", LocalDate.now()),
        new Dependente("Peter Simpson", LocalDate.now())));
    dto.setHorario(horario);
    dto.setContrato(contrato);
    dto.setTotalDeVendasNoMes(new BigDecimal("6000"));
    dto.setDiasEmViagem(6);

    return dto;
  }

  private Empregado makeBO() {
    Empregado bo = new Empregado();
    Horario horario = new Horario();
    Contrato contrato = new Contrato();

    bo.setNome("Maude Lucas");
    bo.setGenero(EnumGenero.FEMININO);
    bo.setCpf("1234567890");
    bo.setDataNascimento(LocalDate.now());
    bo.setDependentes(List.of(
        new Dependente("Peter Simpson", LocalDate.now()),
        new Dependente("Peter Simpson", LocalDate.now())));
    bo.setHorario(horario);
    bo.setContrato(contrato);
    bo.setTotalDeVendasNoMes(new BigDecimal("6000"));
    bo.setDiasEmViagem(6);

    return bo;
  }

  @Test
  void shouldMapToBO() {
    EmpregadoDTO dto = makeDto();

    Empregado bo = EmpregadoMapper.toBO(dto);

    assertEquals(dto.getNome(), bo.getNome());
    assertEquals(dto.getCpf(), bo.getCpf());
    assertEquals(dto.getGenero(), bo.getGenero());
    assertEquals(dto.getDataNascimento(), bo.getDataNascimento());
    assertEquals(dto.getDependentes(), bo.getDependentes());
    assertEquals(dto.getHorario(), bo.getHorario());
    assertEquals(dto.getContrato(), bo.getContrato());
    assertEquals(dto.getTotalDeVendasNoMes(), bo.getTotalDeVendasNoMes());
    assertEquals(dto.getDiasEmViagem(), bo.getDiasEmViagem());
  }

  @Test
  void shouldMapToDTO() {
    Empregado bo = makeBO();

    EmpregadoDTO dto = EmpregadoMapper.toDTO(bo);

    assertEquals(bo.getNome(), dto.getNome());
    assertEquals(bo.getCpf(), dto.getCpf());
    assertEquals(bo.getGenero(), dto.getGenero());
    assertEquals(bo.getDataNascimento(), dto.getDataNascimento());
    assertEquals(bo.getDependentes(), dto.getDependentes());
    assertEquals(bo.getHorario(), dto.getHorario());
    assertEquals(bo.getContrato(), dto.getContrato());
    assertEquals(bo.getTotalDeVendasNoMes(), dto.getTotalDeVendasNoMes());
    assertEquals(bo.getDiasEmViagem(), dto.getDiasEmViagem());
  }

}
