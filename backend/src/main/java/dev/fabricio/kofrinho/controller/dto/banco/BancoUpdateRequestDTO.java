package dev.fabricio.kofrinho.controller.dto.banco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BancoUpdateRequestDTO(
        @NotNull
        Integer id,
        @NotBlank
        String nome,
        @NotBlank
        String codigo) {
}
