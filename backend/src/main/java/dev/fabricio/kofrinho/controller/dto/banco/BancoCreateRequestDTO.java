package dev.fabricio.kofrinho.controller.dto.banco;

import jakarta.validation.constraints.NotBlank;

public record BancoCreateRequestDTO(
        @NotBlank
        String nome,
        @NotBlank
        String codigo) {
}
