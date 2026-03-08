package dev.fabricio.kofrinho.controller.dto.categoria;

import dev.fabricio.kofrinho.common.RelationshipAware;
import dev.fabricio.kofrinho.service.api.CategoriaService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
public class CategoriaCreateRequestDTO implements RelationshipAware {

    @NotBlank
    private String nome;

    @NotNull
    private Integer codigo;

    private Integer paiId;

    private Integer usuarioId;

    @Override
    public Map<String, RelationshipConfig> getRelationshipConfig() {
        return Map.of(
                "pai", new RelationshipConfig("paiId", CategoriaService.class)
        );
    }

}
