package dev.fabricio.kofrinho.controller.dto.credor;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CredorCreateRequestDTO {

    @NotBlank
    private String nome;

}
