package dev.fabricio.kofrinho.controller;

import dev.fabricio.kofrinho.common.AbstractController;
import dev.fabricio.kofrinho.controller.dto.banco.BancoCreateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.banco.BancoResponseDTO;
import dev.fabricio.kofrinho.controller.dto.banco.BancoUpdateRequestDTO;
import dev.fabricio.kofrinho.controller.mapper.BancoMapper;
import dev.fabricio.kofrinho.model.Banco;
import dev.fabricio.kofrinho.service.api.BancoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bancos")
public class BancoController extends AbstractController<Banco, Integer, BancoCreateRequestDTO, BancoUpdateRequestDTO, BancoResponseDTO> {

    private final BancoService bancoService;
    private final BancoMapper bancoMapper;

    public BancoController(BancoService bancoService, BancoMapper bancoMapper) {
        this.bancoService = bancoService;
        this.bancoMapper = bancoMapper;
    }

    @Override
    protected BancoService getService() {
        return this.bancoService;
    }

    @Override
    protected BancoMapper getMapper() {
        return this.bancoMapper;
    }
}
