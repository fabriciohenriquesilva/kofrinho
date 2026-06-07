package dev.fabricio.kofrinho.service;

import dev.fabricio.kofrinho.common.AbstractCrudService;
import dev.fabricio.kofrinho.controller.dto.credor.CredorCreateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.credor.CredorUpdateRequestDTO;
import dev.fabricio.kofrinho.controller.mapper.CredorMapper;
import dev.fabricio.kofrinho.model.Credor;
import dev.fabricio.kofrinho.repository.CredorRepository;
import dev.fabricio.kofrinho.service.api.CredorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CredorServiceImpl extends AbstractCrudService<Credor, Integer, CredorCreateRequestDTO, CredorUpdateRequestDTO> implements CredorService {

    private final CredorRepository credorRepository;
    private final CredorMapper credorMapper;

    public CredorServiceImpl(CredorRepository credorRepository, CredorMapper credorMapper) {
        this.credorRepository = credorRepository;
        this.credorMapper = credorMapper;
    }

    @Override
    public CredorRepository getRepository() {
        return credorRepository;
    }

    @Override
    public CredorMapper getMapper() {
        return credorMapper;
    }
}
