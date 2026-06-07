package dev.fabricio.kofrinho.controller.mapper;

import dev.fabricio.kofrinho.common.MapperContract;
import dev.fabricio.kofrinho.controller.dto.credor.CredorCreateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.credor.CredorResponseDTO;
import dev.fabricio.kofrinho.controller.dto.credor.CredorUpdateRequestDTO;
import dev.fabricio.kofrinho.model.Credor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CredorMapper extends MapperContract<Credor, CredorCreateRequestDTO, CredorUpdateRequestDTO, CredorResponseDTO> {

    Credor fromCreateDTO(CredorCreateRequestDTO createRequestDTO);

    Credor fromUpdateDTO(CredorUpdateRequestDTO updateRequestDTO);

    CredorResponseDTO toReponse(Credor entity);

    default Credor fromId(Integer id) {
        if (id == null) {
            return null;
        }

        Credor credor = new Credor();
        credor.setId(id);

        return credor;
    }

}
