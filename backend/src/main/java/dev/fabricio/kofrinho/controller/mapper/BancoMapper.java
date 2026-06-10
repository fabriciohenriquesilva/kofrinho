package dev.fabricio.kofrinho.controller.mapper;

import dev.fabricio.kofrinho.common.MapperContract;
import dev.fabricio.kofrinho.controller.dto.banco.BancoCreateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.banco.BancoResponseDTO;
import dev.fabricio.kofrinho.controller.dto.banco.BancoUpdateRequestDTO;
import dev.fabricio.kofrinho.model.Banco;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BancoMapper extends MapperContract<Banco, BancoCreateRequestDTO, BancoUpdateRequestDTO, BancoResponseDTO> {

    Banco fromCreateDTO(BancoCreateRequestDTO bancoCreateRequestDTO);

    void updateEntity(BancoUpdateRequestDTO updateRequestDTO, @MappingTarget Banco entity);

    BancoResponseDTO toResponse(Banco banco);

    Banco fromId(Integer id);
}
