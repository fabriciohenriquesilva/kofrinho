package dev.fabricio.kofrinho.service.api;

import dev.fabricio.kofrinho.common.BaseCrudService;
import dev.fabricio.kofrinho.controller.dto.credor.CredorCreateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.credor.CredorUpdateRequestDTO;
import dev.fabricio.kofrinho.model.Credor;

public interface CredorService extends BaseCrudService<Credor, Integer, CredorCreateRequestDTO, CredorUpdateRequestDTO> {

}
