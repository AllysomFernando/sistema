package com.fag.sistema.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HoleriteRequestDTO {
    private String cpf;
    private String cnpj;

}
