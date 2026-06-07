package dev.fabricio.kofrinho.controller.dto.credor;

import dev.fabricio.kofrinho.common.Identifiable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CredorUpdateRequestDTO implements Identifiable {

    @NotNull
    private Integer id;

    @NotBlank
    private String nome;

}
