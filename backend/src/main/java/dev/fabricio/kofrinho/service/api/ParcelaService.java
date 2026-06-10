package dev.fabricio.kofrinho.service.api;

import dev.fabricio.kofrinho.common.BaseCrudService;
import dev.fabricio.kofrinho.controller.dto.transacao.parcela.ParcelaCreateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.transacao.parcela.ParcelaUpdateRequestDTO;
import dev.fabricio.kofrinho.model.Parcela;

public interface ParcelaService extends BaseCrudService<Parcela, Integer, ParcelaCreateRequestDTO, ParcelaUpdateRequestDTO> {

    Parcela buildParcela(ParcelaUpdateRequestDTO parcelaDTO);

    Parcela applyChanges(ParcelaUpdateRequestDTO parcelaDTO);
}
