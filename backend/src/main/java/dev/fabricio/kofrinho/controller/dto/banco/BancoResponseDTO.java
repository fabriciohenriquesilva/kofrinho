package dev.fabricio.kofrinho.controller.dto.banco;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonPropertyOrder({"id", "nome", "codigo", "dataCriacao", "version"})
public class BancoResponseDTO {

    private Integer id;

    private String nome;

    private String codigo;

    private LocalDateTime dataCriacao;

    private Integer version;
}
