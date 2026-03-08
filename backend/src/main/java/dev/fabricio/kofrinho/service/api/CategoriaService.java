package dev.fabricio.kofrinho.service.api;

import dev.fabricio.kofrinho.common.BaseCrudService;
import dev.fabricio.kofrinho.controller.dto.categoria.CategoriaCreateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.categoria.CategoriaUpdateRequestDTO;
import dev.fabricio.kofrinho.model.Categoria;

public interface CategoriaService extends BaseCrudService<Categoria, Integer, CategoriaCreateRequestDTO, CategoriaUpdateRequestDTO> {
}
