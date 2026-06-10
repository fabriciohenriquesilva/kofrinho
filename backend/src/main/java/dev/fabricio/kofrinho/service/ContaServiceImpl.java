package dev.fabricio.kofrinho.service;

import dev.fabricio.kofrinho.common.AbstractCrudService;
import dev.fabricio.kofrinho.controller.dto.conta.ContaCreateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.conta.ContaUpdateRequestDTO;
import dev.fabricio.kofrinho.controller.mapper.ContaMapper;
import dev.fabricio.kofrinho.exception.RegraDeNegocioException;
import dev.fabricio.kofrinho.exception.ServiceException;
import dev.fabricio.kofrinho.model.Banco;
import dev.fabricio.kofrinho.model.Conta;
import dev.fabricio.kofrinho.repository.ContaRepository;
import dev.fabricio.kofrinho.service.api.BancoService;
import dev.fabricio.kofrinho.service.api.ContaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContaServiceImpl extends AbstractCrudService<Conta, Integer, ContaCreateRequestDTO, ContaUpdateRequestDTO> implements ContaService {

    private final ContaRepository contaRepository;
    private final ContaMapper contaMapper;
    private final BancoService bancoService;

    public ContaServiceImpl(ContaRepository contaRepository, ContaMapper contaMapper, BancoService bancoService) {
        this.contaRepository = contaRepository;
        this.contaMapper = contaMapper;
        this.bancoService = bancoService;
    }

    @Override
    public ContaRepository getRepository() {
        return contaRepository;
    }

    @Override
    public ContaMapper getMapper() {
        return contaMapper;
    }

    @Override
    public void validate(Conta entity) throws ServiceException {
        if (entity.getBanco() == null) {
            throw new RegraDeNegocioException("A conta deve estar associada a um banco!");
        }
    }

    @Override
    public void updateRelationships(ContaUpdateRequestDTO updateRequest, Conta conta) {
        if (updateRequest.getBancoId() != null) {
            Banco banco = bancoService.findById(updateRequest.getBancoId());
            conta.setBanco(banco);
        }
    }
}
