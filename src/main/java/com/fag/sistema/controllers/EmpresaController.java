package com.fag.sistema.controllers;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fag.sistema.domain.dto.EmpregadorDTO;
import com.fag.sistema.service.EmpresaService;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
    private EmpresaService empresaService;
    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping
    public List<EmpregadorDTO> listarEmpresas(){
        return empresaService.getAllEmpresas();
    }

}
