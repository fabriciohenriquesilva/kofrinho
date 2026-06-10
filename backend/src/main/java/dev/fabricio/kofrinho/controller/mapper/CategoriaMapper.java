package dev.fabricio.kofrinho.controller.mapper;

import dev.fabricio.kofrinho.common.MapperContract;
import dev.fabricio.kofrinho.controller.dto.categoria.CategoriaCreateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.categoria.CategoriaResponseDTO;
import dev.fabricio.kofrinho.controller.dto.categoria.CategoriaUpdateRequestDTO;
import dev.fabricio.kofrinho.model.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoriaMapper extends MapperContract<Categoria, CategoriaCreateRequestDTO, CategoriaUpdateRequestDTO, CategoriaResponseDTO> {

    @Mapping(source = "paiId", target = "pai")
    Categoria fromCreateDTO(CategoriaCreateRequestDTO createRequestDTO);

    @Mapping(target = "pai", ignore = true)
    void updateEntity(CategoriaUpdateRequestDTO dto, @MappingTarget Categoria entity);

    CategoriaResponseDTO toResponse(Categoria entity);

    Categoria fromId(Integer id);

}
