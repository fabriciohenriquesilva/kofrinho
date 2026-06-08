package dev.fabricio.kofrinho.controller.mapper;

import dev.fabricio.kofrinho.common.MapperContract;
import dev.fabricio.kofrinho.controller.dto.conta.ContaCreateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.conta.ContaResponseDTO;
import dev.fabricio.kofrinho.controller.dto.conta.ContaUpdateRequestDTO;
import dev.fabricio.kofrinho.model.Conta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = BancoMapper.class)
public interface ContaMapper extends MapperContract<Conta, ContaCreateRequestDTO, ContaUpdateRequestDTO, ContaResponseDTO> {

    @Mapping(source = "bancoId", target = "banco")
    Conta fromCreateDTO(ContaCreateRequestDTO createRequestDTO);

    @Mapping(source = "bancoId", target = "banco")
    Conta fromUpdateDTO(ContaUpdateRequestDTO updateRequestDTO);

    ContaResponseDTO toResponse(Conta entity);

    Conta fromId(Integer id);
}
