package dev.fabricio.kofrinho.service;

import dev.fabricio.kofrinho.common.AbstractCrudService;
import dev.fabricio.kofrinho.controller.dto.banco.BancoCreateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.banco.BancoUpdateRequestDTO;
import dev.fabricio.kofrinho.controller.mapper.BancoMapper;
import dev.fabricio.kofrinho.model.Banco;
import dev.fabricio.kofrinho.repository.BancoRepository;
import dev.fabricio.kofrinho.service.api.BancoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BancoServiceImpl extends AbstractCrudService<Banco, Integer, BancoCreateRequestDTO, BancoUpdateRequestDTO> implements BancoService {

    private final BancoRepository bancoRepository;
    private final BancoMapper bancoMapper;

    public BancoServiceImpl(BancoRepository bancoRepository, BancoMapper bancoMapper) {
        this.bancoRepository = bancoRepository;
        this.bancoMapper = bancoMapper;
    }

    @Override
    public BancoRepository getRepository() {
        return bancoRepository;
    }

    @Override
    public BancoMapper getMapper() {
        return bancoMapper;
    }
}
