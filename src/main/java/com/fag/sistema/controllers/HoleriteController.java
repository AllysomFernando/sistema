package com.fag.sistema.controllers;


import com.fag.sistema.domain.dto.HoleriteRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fag.sistema.domain.dto.HoleriteDTO;
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
    public ResponseEntity<HoleriteDTO> criarHolerite(@RequestBody HoleriteRequestDTO request) {
        HoleriteDTO holeriteDTO = holeriteService.criarHolerite(request.getCpf(), request.getCnpj());
        return ResponseEntity.ok(holeriteDTO);
    }
}
