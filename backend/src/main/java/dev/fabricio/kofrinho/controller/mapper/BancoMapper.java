package dev.fabricio.kofrinho.controller.mapper;

import dev.fabricio.kofrinho.common.BaseMapper;
import dev.fabricio.kofrinho.controller.dto.banco.BancoCreateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.banco.BancoResponseDTO;
import dev.fabricio.kofrinho.model.Banco;
import org.springframework.stereotype.Component;

@Component
public class BancoMapper extends BaseMapper<Banco, BancoCreateRequestDTO, BancoResponseDTO> {

    public BancoMapper() {
        super(Banco.class, BancoResponseDTO.class);
    }
}
