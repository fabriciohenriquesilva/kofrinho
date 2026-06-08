package dev.fabricio.kofrinho.common;

public interface MapperContract<E, C, U, R> {

    E fromCreateDTO(C createRequestDTO);

    E fromUpdateDTO(U updateRequestDTO);

    R toResponse(E entity);

    E fromId(Integer id);

}
