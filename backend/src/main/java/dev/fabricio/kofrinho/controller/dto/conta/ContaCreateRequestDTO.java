package dev.fabricio.kofrinho.controller.dto.conta;

import dev.fabricio.kofrinho.common.RelationshipAware;
import dev.fabricio.kofrinho.service.api.BancoService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ContaCreateRequestDTO implements RelationshipAware {

    @NotBlank
    private String nome;

    @NotBlank
    private String agencia;

    @NotBlank
    private String codigo;

    @NotNull
    private Integer bancoId;

    @Override
    public Map<String, RelationshipConfig> getRelationshipConfig() {
        return Map.of("banco", new RelationshipConfig("bancoId", BancoService.class));
    }
}
