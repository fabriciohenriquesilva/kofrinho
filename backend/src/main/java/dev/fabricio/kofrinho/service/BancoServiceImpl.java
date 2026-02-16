package dev.fabricio.kofrinho.service;

import dev.fabricio.kofrinho.common.AbstractCrudService;
import dev.fabricio.kofrinho.model.Banco;
import dev.fabricio.kofrinho.repository.BancoRepository;
import dev.fabricio.kofrinho.service.api.BancoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BancoServiceImpl extends AbstractCrudService<Banco, Integer> implements BancoService {

    private final BancoRepository bancoRepository;

    public BancoServiceImpl(BancoRepository bancoRepository) {
        this.bancoRepository = bancoRepository;
    }

    @Override
    public BancoRepository getRepository() {
        return bancoRepository;
    }
}
