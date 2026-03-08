package dev.fabricio.kofrinho.service.api;

import dev.fabricio.kofrinho.common.BaseCrudService;
import dev.fabricio.kofrinho.controller.dto.banco.BancoCreateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.banco.BancoUpdateRequestDTO;
import dev.fabricio.kofrinho.model.Banco;

public interface BancoService extends BaseCrudService<Banco, Integer, BancoCreateRequestDTO, BancoUpdateRequestDTO> {

}
