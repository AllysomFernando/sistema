package com.fag.sistema.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fag.sistema.domain.dto.HoleriteDTO;
import com.fag.sistema.service.HoleriteSerivce;

@RestController
@RequestMapping("/holerite")
public class HoleriteController {
    @Autowired
    private HoleriteSerivce holeriteSerivce;
    
    @PostMapping
    public ResponseEntity<HoleriteDTO> criarHolerite(@RequestBody String cpf, String cnpj ){
        HoleriteDTO holeriteDTO = holeriteSerivce.criarHolerite(cpf, cnpj);
        return ResponseEntity.ok(holeriteDTO);
    }
}
