package com.fag.sistema.domain.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fag.sistema.domain.dto.EmpresaDTO;
import com.fag.sistema.domain.entities.empregado.Empregado;
import com.fag.sistema.domain.entities.empresa.Empresa;
import com.fag.sistema.domain.entities.empresa.Inscricao;

public class EmpregadorMapperTest {
  
  private EmpresaDTO makeDto() {
    EmpresaDTO empresa = new EmpresaDTO();
    Inscricao inscricao = new Inscricao();

    empresa.setCnpj("12345678000122");
    empresa.setNomeFantasia("Empresa Test");
    empresa.setEmpregados(List.of(
      new Empregado(),
      new Empregado()
    ));
    empresa.setInscricao(inscricao);
    empresa.setCargaHorariaDiaria(8.0f);
    empresa.setDiasATrabalhar(27);
    empresa.setRamoAtividade("Ramo mock");
    empresa.setRazaoSocial("Empresa Test ltda");

    return empresa;
  }

  private Empresa makeBO() {
    Empresa empresa = new Empresa();
    Inscricao inscricao = new Inscricao();

    empresa.setCnpj("12345678000122");
    empresa.setNomeFantasia("Empresa Test");
    empresa.setEmpregados(List.of(
      new Empregado(),
      new Empregado()
    ));
    empresa.setInscricao(inscricao);
    empresa.setCargaHorariaDiaria(8.0f);
    empresa.setDiasATrabalhar(27);
    empresa.setRamoAtividade("Ramo mock");
    empresa.setRazaoSocial("Empresa Test ltda");

    return empresa;
  }

  @Test
  void shouldMapToBO() {
    EmpresaDTO empresa = makeDto();

    Empresa bo = EmpresaMapper.toBO(empresa);

    assertEquals(empresa.getCnpj(), bo.getCnpj());
    assertEquals(empresa.getNomeFantasia(), bo.getNomeFantasia());
    assertEquals(empresa.getRazaoSocial(), bo.getRazaoSocial());
    assertEquals(empresa.getEmpregados(), bo.getEmpregados());
    assertEquals(empresa.getInscricao(), bo.getInscricao());
    assertEquals(empresa.getDiasATrabalhar(), bo.getDiasATrabalhar());
    assertEquals(empresa.getCargaHorariaDiaria(), bo.getCargaHorariaDiaria());
    assertEquals(empresa.getRamoAtividade(), bo.getRamoAtividade());
  }

  @Test
  void shouldMapToDto() {
    Empresa empresa = makeBO();

    EmpresaDTO bo = EmpresaMapper.toDTO(empresa);

    assertEquals(empresa.getCnpj(), bo.getCnpj());
    assertEquals(empresa.getNomeFantasia(), bo.getNomeFantasia());
    assertEquals(empresa.getRazaoSocial(), bo.getRazaoSocial());
    assertEquals(empresa.getEmpregados(), bo.getEmpregados());
    assertEquals(empresa.getInscricao(), bo.getInscricao());
    assertEquals(empresa.getDiasATrabalhar(), bo.getDiasATrabalhar());
    assertEquals(empresa.getCargaHorariaDiaria(), bo.getCargaHorariaDiaria());
    assertEquals(empresa.getRamoAtividade(), bo.getRamoAtividade());
  }
}
