package dev.fabricio.kofrinho.controller.mapper;

import dev.fabricio.kofrinho.common.MapperContract;
import dev.fabricio.kofrinho.controller.dto.categoria.CategoriaCreateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.categoria.CategoriaResponseDTO;
import dev.fabricio.kofrinho.controller.dto.categoria.CategoriaUpdateRequestDTO;
import dev.fabricio.kofrinho.model.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoriaMapper extends MapperContract<Categoria, CategoriaCreateRequestDTO, CategoriaUpdateRequestDTO, CategoriaResponseDTO> {

    @Mapping(source = "paiId", target = "pai")
    Categoria fromCreateDTO(CategoriaCreateRequestDTO createRequestDTO);

    @Mapping(source = "paiId", target = "pai")
    Categoria fromUpdateDTO(CategoriaUpdateRequestDTO updateRequestDTO);

    CategoriaResponseDTO toReponse(Categoria entity);

    default Categoria fromId(Integer id) {
        if (id == null) {
            return null;
        }

        Categoria categoria = new Categoria();
        categoria.setId(id);

        return categoria;
    }
}
