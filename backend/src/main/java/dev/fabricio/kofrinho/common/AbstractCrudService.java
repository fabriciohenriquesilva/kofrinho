package dev.fabricio.kofrinho.common;

import dev.fabricio.kofrinho.exception.RegistroNaoEncontradoException;
import dev.fabricio.kofrinho.exception.ServiceException;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@SuppressWarnings("unchecked")
public abstract class AbstractCrudService<T extends BaseEntity, ID> implements BaseCrudService<T, ID> {

    public abstract JpaRepository getRepository();

    public T save(T entity) {
        try {
            beforeSave(entity);
            entity = (T) getRepository().save(entity);
            afterSave(entity);
            return entity;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public T findById(ID id) throws RuntimeException {
        Optional<T> findById = getRepository().findById(id);

        if (findById.isEmpty()) {
            throw new RegistroNaoEncontradoException("Não foi possível localizar o registro: " + id);
        }

        return findById.get();
    }

    public T update(T source) {
        try {
            beforeUpdate(source);

            Optional<T> findById = getRepository().findById(source.getId());
            if (findById.isEmpty()) {
                throw new RegistroNaoEncontradoException(source.getId());
            }
            T foundEntity = findById.get();

            BeanUtils.copyProperties(source, foundEntity, "id", "dataCriacao", "version");
            foundEntity = (T) getRepository().save(foundEntity);

            afterUpdate(foundEntity);
            return foundEntity;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public void delete(ID id) {
        try {
            getRepository().deleteById(id);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public void beforeSave(T entity) {
        entity.setDataCriacao(LocalDateTime.now());
    }

    public void afterSave(T entity) {

    }

    public void beforeUpdate(T entity) {

    }

    public void afterUpdate(T entity) {

    }

}
