package dev.fabricio.kofrinho.service;

import dev.fabricio.kofrinho.common.AbstractCrudService;
import dev.fabricio.kofrinho.controller.dto.categoria.CategoriaCreateRequestDTO;
import dev.fabricio.kofrinho.controller.dto.categoria.CategoriaUpdateRequestDTO;
import dev.fabricio.kofrinho.controller.mapper.CategoriaMapper;
import dev.fabricio.kofrinho.exception.ServiceException;
import dev.fabricio.kofrinho.model.Categoria;
import dev.fabricio.kofrinho.repository.CategoriaRepository;
import dev.fabricio.kofrinho.service.api.CategoriaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.List;

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

    @Override
    public void validate(Categoria entity) throws ServiceException {
        List<Categoria> optional = getRepository().findCategoriaByCodigo(entity.getCodigo());

        if (!optional.isEmpty()) {
            throw new ServiceException(MessageFormat.format("Já existe uma categoria com o código {0}. Por favor, informe outro código", entity.getCodigo()));
        }
    }
}
