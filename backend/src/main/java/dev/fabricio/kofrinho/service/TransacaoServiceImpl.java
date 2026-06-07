package dev.fabricio.kofrinho.service;

import dev.fabricio.kofrinho.common.AbstractCrudService;
import dev.fabricio.kofrinho.controller.dto.transacao.TransacaoCreateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.transacao.TransacaoUpdateRequestDTO;
import dev.fabricio.kofrinho.controller.mapper.TransacaoMapper;
import dev.fabricio.kofrinho.model.Transacao;
import dev.fabricio.kofrinho.repository.TransacaoRepository;
import dev.fabricio.kofrinho.service.api.TransacaoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class TransacaoServiceImpl extends AbstractCrudService<Transacao, Integer, TransacaoCreateRequestDTO, TransacaoUpdateRequestDTO> implements TransacaoService {

    private final TransacaoRepository transacaoRepository;
    private final TransacaoMapper transacaoMapper;

    public TransacaoServiceImpl(TransacaoRepository transacaoRepository, TransacaoMapper transacaoMapper) {
        this.transacaoRepository = transacaoRepository;
        this.transacaoMapper = transacaoMapper;
    }

    @Override
    public TransacaoRepository getRepository() {
        return transacaoRepository;
    }

    @Override
    public TransacaoMapper getMapper() {
        return transacaoMapper;
    }

    @Override
    public void beforeSave(Transacao entity) {
        entity.getParcelaList().forEach(parcela -> {
            parcela.setTransacao(entity);
            parcela.setDataCriacao(LocalDateTime.now());
        });
    }
}
