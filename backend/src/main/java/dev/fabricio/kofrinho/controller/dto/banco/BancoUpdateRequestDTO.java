package dev.fabricio.kofrinho.controller.dto.banco;

import dev.fabricio.kofrinho.common.Identifiable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BancoUpdateRequestDTO implements Identifiable {

        @NotNull
        private Integer id;

        @NotBlank
        private String nome;

        @NotBlank
        private String codigo;
}
