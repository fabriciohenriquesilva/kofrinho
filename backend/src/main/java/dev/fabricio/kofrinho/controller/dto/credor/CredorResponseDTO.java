package dev.fabricio.kofrinho.controller.dto.credor;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({"id", "nome"})
public class CredorResponseDTO {

    private Integer id;

    private String nome;

}
