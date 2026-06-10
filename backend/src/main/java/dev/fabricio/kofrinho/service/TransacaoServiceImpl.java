package dev.fabricio.kofrinho.service;

import dev.fabricio.kofrinho.common.AbstractCrudService;
import dev.fabricio.kofrinho.controller.dto.transacao.TransacaoCreateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.transacao.TransacaoUpdateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.transacao.parcela.ParcelaUpdateRequestDTO;
import dev.fabricio.kofrinho.controller.mapper.TransacaoMapper;
import dev.fabricio.kofrinho.model.Categoria;
import dev.fabricio.kofrinho.model.Credor;
import dev.fabricio.kofrinho.model.Parcela;
import dev.fabricio.kofrinho.model.Transacao;
import dev.fabricio.kofrinho.repository.TransacaoRepository;
import dev.fabricio.kofrinho.service.api.CategoriaService;
import dev.fabricio.kofrinho.service.api.CredorService;
import dev.fabricio.kofrinho.service.api.ParcelaService;
import dev.fabricio.kofrinho.service.api.TransacaoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class TransacaoServiceImpl extends AbstractCrudService<Transacao, Integer, TransacaoCreateRequestDTO, TransacaoUpdateRequestDTO> implements TransacaoService {

    private final TransacaoRepository transacaoRepository;
    private final TransacaoMapper transacaoMapper;
    private final CredorService credorService;
    private final CategoriaService categoriaService;
    private final ParcelaService parcelaService;

    public TransacaoServiceImpl(TransacaoRepository transacaoRepository, TransacaoMapper transacaoMapper, CredorService credorService, CategoriaService categoriaService, ParcelaService parcelaService) {
        this.transacaoRepository = transacaoRepository;
        this.transacaoMapper = transacaoMapper;
        this.credorService = credorService;
        this.categoriaService = categoriaService;
        this.parcelaService = parcelaService;
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

    @Override
    public void updateRelationships(TransacaoUpdateRequestDTO updateRequest, Transacao transacao) {
        if (updateRequest.getCredorId() != null) {
            Credor credor = credorService.findById(updateRequest.getCredorId());
            transacao.setCredor(credor);
        }
        if (updateRequest.getCategoriaId() != null) {
            Categoria categoria = categoriaService.findById(updateRequest.getCategoriaId());
            transacao.setCategoria(categoria);
        }

        List<Parcela> parcelasPersistidas = transacao.getParcelaList();

        for (ParcelaUpdateRequestDTO parcelaDTO : updateRequest.getParcelaList()) {
            if (parcelaDTO.getId() == null) {
                Parcela parcela = parcelaService.buildParcela(parcelaDTO);
                parcela.setTransacao(transacao);
                parcelasPersistidas.add(parcela);
            } else {
                Parcela parcela = parcelaService.applyChanges(parcelaDTO);
                parcela.setTransacao(transacao);
            }
        }

        List<Integer> parcelaIdDTOList = updateRequest.getParcelaList().stream().map(ParcelaUpdateRequestDTO::getId).toList();
        parcelasPersistidas.removeIf(parcela -> parcela.getId() != null && !parcelaIdDTOList.contains(parcela.getId()));
    }
}
