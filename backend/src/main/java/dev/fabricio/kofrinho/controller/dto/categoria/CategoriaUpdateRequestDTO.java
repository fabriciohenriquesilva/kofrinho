package dev.fabricio.kofrinho.controller.dto.categoria;

import dev.fabricio.kofrinho.common.Updatable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaUpdateRequestDTO implements Updatable {

    @NotNull
    private Integer id;

    @NotBlank
    private String nome;

    @NotNull
    private Integer codigo;

    private Integer paiId;

}
