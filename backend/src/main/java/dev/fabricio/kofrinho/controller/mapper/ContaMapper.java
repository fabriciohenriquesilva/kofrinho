package dev.fabricio.kofrinho.controller.mapper;

import dev.fabricio.kofrinho.common.BaseMapper;
import dev.fabricio.kofrinho.controller.dto.conta.ContaCreateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.conta.ContaResponseDTO;
import dev.fabricio.kofrinho.controller.dto.conta.ContaUpdateRequestDTO;
import dev.fabricio.kofrinho.model.Conta;
import org.springframework.stereotype.Component;

@Component
public class ContaMapper extends BaseMapper<Conta, ContaCreateRequestDTO, ContaUpdateRequestDTO, ContaResponseDTO> {

    private final BancoMapper bancoMapper;

    public ContaMapper(BancoMapper bancoMapper) {
        super(Conta.class, ContaResponseDTO.class);
        this.bancoMapper = bancoMapper;
    }

    @Override
    public void mapRelations(Conta entity, ContaResponseDTO response) {
        response.setBanco(bancoMapper.toDTO(entity.getBanco()));
    }
}
