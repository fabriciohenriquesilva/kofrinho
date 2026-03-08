package dev.fabricio.kofrinho.controller.dto.categoria;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import dev.fabricio.kofrinho.controller.dto.usuario.UsuarioResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonPropertyOrder({"id", "codigo", "nome", "dataCriacao", "pai", "usuario"})
public class CategoriaResponseDTO {

    private Integer id;

    private Integer codigo;

    private String nome;

    private LocalDateTime dataCriacao;

    private CategoriaResponseDTO pai;

    private UsuarioResponseDTO usuario;

}
