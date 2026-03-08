package dev.fabricio.kofrinho.controller;

import dev.fabricio.kofrinho.common.AbstractController;
import dev.fabricio.kofrinho.controller.dto.categoria.CategoriaCreateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.categoria.CategoriaResponseDTO;
import dev.fabricio.kofrinho.controller.dto.categoria.CategoriaUpdateRequestDTO;
import dev.fabricio.kofrinho.controller.mapper.CategoriaMapper;
import dev.fabricio.kofrinho.model.Categoria;
import dev.fabricio.kofrinho.service.api.CategoriaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categorias")
public class CategoriaController extends AbstractController<Categoria, Integer, CategoriaCreateRequestDTO, CategoriaUpdateRequestDTO, CategoriaResponseDTO> {

    private final CategoriaService categoriaService;
    private final CategoriaMapper categoriaMapper;

    public CategoriaController(CategoriaService categoriaService, CategoriaMapper categoriaMapper) {
        this.categoriaService = categoriaService;
        this.categoriaMapper = categoriaMapper;
    }

    @Override
    protected CategoriaService getService() {
        return categoriaService;
    }

    @Override
    protected CategoriaMapper getMapper() {
        return categoriaMapper;
    }
}
