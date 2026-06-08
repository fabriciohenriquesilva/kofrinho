package dev.fabricio.kofrinho.common;

public interface MapperContract<E extends BaseEntity, C, U, R> {

    E fromCreateDTO(C createRequestDTO);

    E fromUpdateDTO(U updateRequestDTO);

    R toResponse(E entity);

    E fromId(Integer id);

}
