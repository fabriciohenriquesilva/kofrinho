package dev.fabricio.kofrinho.common;

import org.mapstruct.MappingTarget;

public interface MapperContract<E extends BaseEntity, C, U, R> {

    E fromCreateDTO(C createRequestDTO);

    void updateEntity(U updateRequestDTO, @MappingTarget E entity);

    R toResponse(E entity);

    E fromId(Integer id);

}
