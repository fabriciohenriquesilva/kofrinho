package dev.fabricio.kofrinho.controller;

import dev.fabricio.kofrinho.common.AbstractController;
import dev.fabricio.kofrinho.controller.dto.conta.ContaCreateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.conta.ContaResponseDTO;
import dev.fabricio.kofrinho.controller.dto.conta.ContaUpdateRequestDTO;
import dev.fabricio.kofrinho.controller.mapper.ContaMapper;
import dev.fabricio.kofrinho.model.Conta;
import dev.fabricio.kofrinho.service.api.ContaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("contas")
public class ContaController extends AbstractController<Conta, Integer, ContaCreateRequestDTO, ContaUpdateRequestDTO, ContaResponseDTO> {

    private final ContaService contaService;
    private final ContaMapper contaMapper;

    public ContaController(ContaService contaService, ContaMapper contaMapper) {
        this.contaService = contaService;
        this.contaMapper = contaMapper;
    }

    @Override
    protected ContaService getService() {
        return this.contaService;
    }

    @Override
    protected ContaMapper getMapper() {
        return this.contaMapper;
    }
}
