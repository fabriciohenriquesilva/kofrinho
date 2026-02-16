package dev.fabricio.kofrinho.controller.mapper;

import dev.fabricio.kofrinho.common.BaseMapper;
import dev.fabricio.kofrinho.controller.dto.conta.ContaCreateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.conta.ContaResponseDTO;
import dev.fabricio.kofrinho.controller.dto.conta.ContaUpdateRequestDTO;
import dev.fabricio.kofrinho.model.Banco;
import dev.fabricio.kofrinho.model.Conta;
import dev.fabricio.kofrinho.service.api.ContaService;
import org.springframework.stereotype.Component;

@Component
public class ContaMapper extends BaseMapper<Conta, Integer, ContaCreateRequestDTO, ContaUpdateRequestDTO, ContaResponseDTO> {

    private final BancoMapper bancoMapper;
    private final ContaService contaService;

    public ContaMapper(BancoMapper bancoMapper, ContaService contaService) {
        super(Conta.class, ContaResponseDTO.class);
        this.bancoMapper = bancoMapper;
        this.contaService = contaService;
    }

    @Override
    protected ContaService getService() {
        return contaService;
    }

    @Override
    public Conta toEntityFromCreateRequest(ContaCreateRequestDTO dto) {
        Conta entity = super.toEntityFromCreateRequest(dto);
        Banco banco = bancoMapper.fromId(dto.bancoId());
        entity.setBanco(banco);
        return entity;
    }

    @Override
    public ContaResponseDTO toDTO(Conta entity) {
        ContaResponseDTO response = super.toDTO(entity);
        response.setBanco(bancoMapper.toDTO(entity.getBanco()));
        return response;
    }
}
