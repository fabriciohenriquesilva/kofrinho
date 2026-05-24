package dev.fabricio.kofrinho.controller.dto.categoria;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoriaCreateRequestDTO {

    @NotBlank
    private String nome;

    @NotNull
    private String codigo;

    private Integer paiId;

    private Integer usuarioId;

}
