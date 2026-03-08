package dev.fabricio.kofrinho.controller.dto.banco;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BancoCreateRequestDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String codigo;

}
