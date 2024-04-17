package com.fag.sistema.domain.dto;

import com.fag.sistema.domain.entities.empregado.Horario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HoleriteRequestDTO {
    private String cpf;
    private String cnpj;
    private Horario horario;
}
