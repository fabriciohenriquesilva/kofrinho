package dev.fabricio.kofrinho.service;

import dev.fabricio.kofrinho.common.AbstractCrudService;
import dev.fabricio.kofrinho.controller.dto.transacao.parcela.ParcelaCreateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.transacao.parcela.ParcelaUpdateRequestDTO;
import dev.fabricio.kofrinho.controller.mapper.ParcelaMapper;
import dev.fabricio.kofrinho.model.Conta;
import dev.fabricio.kofrinho.model.Parcela;
import dev.fabricio.kofrinho.repository.ParcelaRepository;
import dev.fabricio.kofrinho.service.api.ContaService;
import dev.fabricio.kofrinho.service.api.ParcelaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class ParcelaServiceImpl extends AbstractCrudService<Parcela, Integer, ParcelaCreateRequestDTO, ParcelaUpdateRequestDTO> implements ParcelaService {

    private final ParcelaRepository parcelaRepository;
    private final ParcelaMapper parcelaMapper;
    private final ContaService contaService;

    public ParcelaServiceImpl(ParcelaRepository parcelaRepository, ParcelaMapper parcelaMapper, ContaService contaService) {
        this.parcelaRepository = parcelaRepository;
        this.parcelaMapper = parcelaMapper;
        this.contaService = contaService;
    }

    @Override
    public ParcelaRepository getRepository() {
        return parcelaRepository;
    }

    @Override
    public ParcelaMapper getMapper() {
        return parcelaMapper;
    }

    @Override
    public Parcela buildParcela(ParcelaUpdateRequestDTO parcelaDTO) {
        Parcela parcela = parcelaMapper.fromUpdateDTO(parcelaDTO);
        parcela.setDataCriacao(LocalDateTime.now());

        if (parcelaDTO.getContaId() != null) {
            Conta conta = contaService.findById(parcelaDTO.getContaId());
            parcela.setConta(conta);
        }

        return parcela;
    }

    @Override
    public Parcela applyChanges(ParcelaUpdateRequestDTO parcelaDTO) {
        Parcela parcela = findById(parcelaDTO.getId());
        parcelaMapper.updateEntity(parcelaDTO, parcela);

        if (parcelaDTO.getContaId() != null) {
            Conta conta = contaService.findById(parcelaDTO.getContaId());
            parcela.setConta(conta);
        }

        return parcela;
    }
}
