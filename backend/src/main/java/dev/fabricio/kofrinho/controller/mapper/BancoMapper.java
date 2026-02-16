package dev.fabricio.kofrinho.controller.mapper;

import dev.fabricio.kofrinho.common.BaseMapper;
import dev.fabricio.kofrinho.controller.dto.banco.BancoCreateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.banco.BancoResponseDTO;
import dev.fabricio.kofrinho.controller.dto.banco.BancoUpdateRequestDTO;
import dev.fabricio.kofrinho.model.Banco;
import dev.fabricio.kofrinho.service.api.BancoService;
import org.springframework.stereotype.Component;

@Component
public class BancoMapper extends BaseMapper<Banco, Integer, BancoCreateRequestDTO, BancoUpdateRequestDTO, BancoResponseDTO> {

    private final BancoService bancoService;

    public BancoMapper(BancoService bancoService) {
        super(Banco.class, BancoResponseDTO.class);
        this.bancoService = bancoService;
    }

    @Override
    protected BancoService getService() {
        return bancoService;
    }
}
