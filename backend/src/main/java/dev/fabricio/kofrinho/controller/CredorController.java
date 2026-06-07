package dev.fabricio.kofrinho.controller;

import dev.fabricio.kofrinho.common.AbstractController;
import dev.fabricio.kofrinho.controller.dto.credor.CredorCreateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.credor.CredorResponseDTO;
import dev.fabricio.kofrinho.controller.dto.credor.CredorUpdateRequestDTO;
import dev.fabricio.kofrinho.controller.mapper.CredorMapper;
import dev.fabricio.kofrinho.model.Credor;
import dev.fabricio.kofrinho.service.api.CredorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("credores")
public class CredorController extends AbstractController<Credor, Integer, CredorCreateRequestDTO, CredorUpdateRequestDTO, CredorResponseDTO> {

    private final CredorService credorService;
    private final CredorMapper credorMapper;

    public CredorController(CredorService credorService, CredorMapper credorMapper) {
        this.credorService = credorService;
        this.credorMapper = credorMapper;
    }

    @Override
    protected CredorService getService() {
        return credorService;
    }

    @Override
    protected CredorMapper getMapper() {
        return credorMapper;
    }
}
