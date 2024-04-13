package com.fag.sistema.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fag.sistema.domain.dto.EmpregadorDTO;
import com.fag.sistema.service.EmpresaService;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public List<EmpregadorDTO> listarEmpresas() {
        return empresaService.getAllEmpresas();
    }

    @GetMapping("/{cnpj}")
    public EmpregadorDTO getEmpresaByCnpj(@PathVariable(value = "cnpj") String cnpj) {
        return empresaService.getEmpresaByCNPJ(cnpj);
    }

}
