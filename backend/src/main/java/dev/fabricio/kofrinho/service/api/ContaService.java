package dev.fabricio.kofrinho.service.api;

import dev.fabricio.kofrinho.common.BaseCrudService;
import dev.fabricio.kofrinho.controller.dto.conta.ContaCreateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.conta.ContaUpdateRequestDTO;
import dev.fabricio.kofrinho.model.Conta;

public interface ContaService extends BaseCrudService<Conta, Integer, ContaCreateRequestDTO, ContaUpdateRequestDTO> {
}
