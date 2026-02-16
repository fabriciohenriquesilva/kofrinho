package dev.fabricio.kofrinho.controller.dto.conta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ContaUpdateRequestDTO(
        @NotNull
        Integer id,
        @NotBlank
        String nome,
        @NotBlank
        String agencia,
        @NotBlank
        String codigo,
        @NotNull
        Integer bancoId
) {
}
