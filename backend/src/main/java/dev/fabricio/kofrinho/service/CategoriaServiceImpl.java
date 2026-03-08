package dev.fabricio.kofrinho.service;

import dev.fabricio.kofrinho.common.AbstractCrudService;
import dev.fabricio.kofrinho.controller.dto.categoria.CategoriaCreateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.categoria.CategoriaUpdateRequestDTO;
import dev.fabricio.kofrinho.controller.mapper.CategoriaMapper;
import dev.fabricio.kofrinho.model.Categoria;
import dev.fabricio.kofrinho.repository.CategoriaRepository;
import dev.fabricio.kofrinho.service.api.CategoriaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoriaServiceImpl extends AbstractCrudService<Categoria, Integer, CategoriaCreateRequestDTO, CategoriaUpdateRequestDTO> implements CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository, CategoriaMapper categoriaMapper) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper = categoriaMapper;
    }

    @Override
    public CategoriaRepository getRepository() {
        return categoriaRepository;
    }

    @Override
    public CategoriaMapper getMapper() {
        return categoriaMapper;
    }
}
