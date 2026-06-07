package dev.fabricio.kofrinho.controller.dto.conta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaCreateRequestDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String agencia;

    @NotBlank
    private String codigo;

    @NotNull
    private Integer bancoId;
}
