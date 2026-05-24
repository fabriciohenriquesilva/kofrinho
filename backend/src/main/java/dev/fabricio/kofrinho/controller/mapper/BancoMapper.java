package dev.fabricio.kofrinho.controller.mapper;

import dev.fabricio.kofrinho.common.MapperContract;
import dev.fabricio.kofrinho.controller.dto.banco.BancoCreateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.banco.BancoResponseDTO;
import dev.fabricio.kofrinho.controller.dto.banco.BancoUpdateRequestDTO;
import dev.fabricio.kofrinho.model.Banco;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BancoMapper extends MapperContract<Banco, BancoCreateRequestDTO, BancoUpdateRequestDTO, BancoResponseDTO> {

    Banco fromCreateDTO(BancoCreateRequestDTO bancoCreateRequestDTO);

    Banco fromUpdateDTO(BancoUpdateRequestDTO bancoUpdateRequestDTO);

    BancoResponseDTO toReponse(Banco banco);
}
