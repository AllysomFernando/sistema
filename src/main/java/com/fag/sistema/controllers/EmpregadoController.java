package com.fag.sistema.controllers;


import com.fag.sistema.domain.dto.EmpregadoDTO;
import com.fag.sistema.service.EmpregadoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/empregados")
public class EmpregadoController {

    private EmpregadoService empregadoService;
    public EmpregadoController(EmpregadoService empregadoService) {
        this.empregadoService = empregadoService;
    }

    @GetMapping("/listar")
    public List<EmpregadoDTO> listarEmpregados(){
        return empregadoService.getAllEmpregados();
    }
}
