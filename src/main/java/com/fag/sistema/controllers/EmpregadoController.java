package com.fag.sistema.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fag.sistema.domain.dto.EmpregadoDTO;
import com.fag.sistema.service.EmpregadoService;

@RestController
@RequestMapping("/empregados")
public class EmpregadoController {

    @Autowired
    private EmpregadoService empregadoService;

    @GetMapping
    public List<EmpregadoDTO> listarEmpregados() {
        return empregadoService.getAllEmpregados();
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<EmpregadoDTO> listarEmpregadoPorCPF(@PathVariable String cpf) {
        EmpregadoDTO empregadoDTO = empregadoService.getEmpregadoByCpf(cpf);
        if (empregadoDTO != null) {
            return ResponseEntity.ok(empregadoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
