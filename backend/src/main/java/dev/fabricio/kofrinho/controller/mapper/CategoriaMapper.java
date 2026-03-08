package dev.fabricio.kofrinho.controller.mapper;

import dev.fabricio.kofrinho.common.BaseMapper;
import dev.fabricio.kofrinho.controller.dto.categoria.CategoriaCreateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.categoria.CategoriaResponseDTO;
import dev.fabricio.kofrinho.model.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper extends BaseMapper<Categoria, CategoriaCreateRequestDTO, CategoriaResponseDTO> {

    public CategoriaMapper() {
        super(Categoria.class, CategoriaResponseDTO.class);
    }

    @Override
    public void mapRelationship(Categoria entity, CategoriaResponseDTO response) {
        response.setPai(this.toDTO(entity.getPai()));
    }
}
