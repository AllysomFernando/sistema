package com.fag.sistema.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fag.sistema.service.EmpresaService;

@WebMvcTest(EmpresaController.class)
public class EmpresaController {
  
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private EmpresaService service;

}
