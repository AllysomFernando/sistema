package com.fag.sistema.controllers;


import com.fag.sistema.domain.dto.EmpregadoDTO;
import com.fag.sistema.service.EmpregadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping
    public List<EmpregadoDTO> listarEmpregados(){
        return empregadoService.getAllEmpregados();
    }
    @GetMapping("/{cpf}")
    public ResponseEntity<EmpregadoDTO> listarEmpregadoPorCPF(@PathVariable String cpf){
        EmpregadoDTO empregadoDTO = empregadoService.getEmpregadoporCPF(cpf);
        if(empregadoDTO!=null){
            return ResponseEntity.ok(empregadoDTO);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
