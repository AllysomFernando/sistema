package com.fag.sistema.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fag.sistema.domain.dto.HoleriteRequestDTO;
import com.fag.sistema.domain.entities.Holerite;
import com.fag.sistema.service.HoleriteService;

@RestController
@RequestMapping("/holerite")
public class HoleriteController {
    @Autowired
    private HoleriteService holeriteService;

    public HoleriteController(HoleriteService holeriteService) {
        this.holeriteService = holeriteService;
    }

    @PostMapping
    public ResponseEntity<Holerite> criarHolerite(@RequestBody HoleriteRequestDTO request) {
        Holerite holeriteDTO = holeriteService.criarHolerite(request.getCpf(), request.getCnpj());
        return ResponseEntity.ok(holeriteDTO);
    }
}
