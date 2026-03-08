package dev.fabricio.kofrinho.controller.dto.conta;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import dev.fabricio.kofrinho.controller.dto.banco.BancoResponseDTO;
import dev.fabricio.kofrinho.controller.dto.usuario.UsuarioResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonPropertyOrder({"id", "nome", "agencia", "codigo", "dataCriacao", "banco", "usuario"})
public class ContaResponseDTO {

    private Integer id;

    private String nome;

    private String agencia;

    private String codigo;

    private LocalDateTime dataCriacao;

    private BancoResponseDTO banco;

    private UsuarioResponseDTO usuario;

}
