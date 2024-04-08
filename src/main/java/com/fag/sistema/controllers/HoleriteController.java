package com.fag.sistema.controllers;


import com.fag.sistema.domain.dto.HoleriteDTO;
import com.fag.sistema.domain.entities.Empregado;
import com.fag.sistema.service.HoleriteSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/holerite")
public class HoleriteController {
    private HoleriteSerivce holeriteSerivce;
    @Autowired
    public HoleriteController(HoleriteSerivce holeriteService) {
        this.holeriteSerivce = holeriteService;
    }
    @PostMapping
    public ResponseEntity<HoleriteDTO> criarHolerite(@RequestBody String cpf, String cnpj ){
        HoleriteDTO holeriteDTO = holeriteSerivce.criarHolerite(cpf, cnpj);
        return ResponseEntity.ok(holeriteDTO);
    }
}
