package com.fag.sistema.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fag.sistema.domain.dto.EmpresaDTO;
import com.fag.sistema.domain.entities.empresa.Empresa;
import com.fag.sistema.domain.mappers.EmpresaMapper;
import com.fag.sistema.service.EmpresaService;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public List<EmpresaDTO> listarEmpresas() {
        return empresaService.getAllEmpresas();
    }

    @GetMapping("/{cnpj}")
    public EmpresaDTO getEmpresaByCnpj(@PathVariable(value = "cnpj") String cnpj) {
        Empresa empresa = empresaService.getEmpresaByCnpj(cnpj);
        return EmpresaMapper.toDTO(empresa);
    }

}
