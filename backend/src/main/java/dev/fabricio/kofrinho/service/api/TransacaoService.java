package dev.fabricio.kofrinho.service.api;

import dev.fabricio.kofrinho.common.BaseCrudService;
import dev.fabricio.kofrinho.controller.dto.transacao.TransacaoCreateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.transacao.TransacaoUpdateRequestDTO;
import dev.fabricio.kofrinho.model.Transacao;

public interface TransacaoService extends BaseCrudService<Transacao, Integer, TransacaoCreateRequestDTO, TransacaoUpdateRequestDTO> {

}
