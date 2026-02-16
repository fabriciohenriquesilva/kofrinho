package dev.fabricio.kofrinho.service;

import dev.fabricio.kofrinho.common.AbstractCrudService;
import dev.fabricio.kofrinho.model.Conta;
import dev.fabricio.kofrinho.repository.ContaRepository;
import dev.fabricio.kofrinho.service.api.ContaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContaServiceImpl extends AbstractCrudService<Conta, Integer> implements ContaService {

    private final ContaRepository contaRepository;

    public ContaServiceImpl(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    @Override
    public ContaRepository getRepository() {
        return contaRepository;
    }

}
