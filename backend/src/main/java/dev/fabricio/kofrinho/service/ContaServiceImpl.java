package dev.fabricio.kofrinho.service;

import dev.fabricio.kofrinho.common.AbstractCrudService;
import dev.fabricio.kofrinho.controller.dto.conta.ContaCreateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.conta.ContaUpdateRequestDTO;
import dev.fabricio.kofrinho.controller.mapper.ContaMapper;
import dev.fabricio.kofrinho.model.Conta;
import dev.fabricio.kofrinho.repository.ContaRepository;
import dev.fabricio.kofrinho.service.api.ContaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContaServiceImpl extends AbstractCrudService<Conta, Integer, ContaCreateRequestDTO, ContaUpdateRequestDTO> implements ContaService {

    private final ContaRepository contaRepository;
    private final ContaMapper contaMapper;

    public ContaServiceImpl(ContaRepository contaRepository, ContaMapper contaMapper) {
        this.contaRepository = contaRepository;
        this.contaMapper = contaMapper;
    }

    @Override
    public ContaRepository getRepository() {
        return contaRepository;
    }

    @Override
    public ContaMapper getMapper() {
        return contaMapper;
    }

}
