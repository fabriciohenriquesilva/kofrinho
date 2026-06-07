package dev.fabricio.kofrinho.controller;

import dev.fabricio.kofrinho.common.AbstractController;
import dev.fabricio.kofrinho.controller.dto.transacao.TransacaoCreateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.transacao.TransacaoResponseDTO;
import dev.fabricio.kofrinho.controller.dto.transacao.TransacaoUpdateRequestDTO;
import dev.fabricio.kofrinho.controller.mapper.TransacaoMapper;
import dev.fabricio.kofrinho.model.Transacao;
import dev.fabricio.kofrinho.service.api.TransacaoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transacoes")
public class TransacaoController extends AbstractController<Transacao, Integer, TransacaoCreateRequestDTO, TransacaoUpdateRequestDTO, TransacaoResponseDTO> {

    private final TransacaoService transacaoService;
    private final TransacaoMapper transacaoMapper;

    public TransacaoController(TransacaoService transacaoService, TransacaoMapper transacaoMapper) {
        this.transacaoService = transacaoService;
        this.transacaoMapper = transacaoMapper;
    }

    @Override
    protected TransacaoService getService() {
        return this.transacaoService;
    }

    @Override
    protected TransacaoMapper getMapper() {
        return this.transacaoMapper;
    }
}
