package dev.fabricio.kofrinho.controller.dto.conta;

import dev.fabricio.kofrinho.common.Updatable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaUpdateRequestDTO implements Updatable {

    @NotNull
    private Integer id;

    @NotBlank
    private String nome;

    @NotBlank
    private String agencia;

    @NotBlank
    private String codigo;

    @NotNull
    private Integer bancoId;

}
