package dev.fabricio.kofrinho.common;

import dev.fabricio.kofrinho.exception.RegistroNaoEncontradoException;
import dev.fabricio.kofrinho.exception.ServiceException;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@SuppressWarnings("unchecked")
@Transactional
public abstract class AbstractCrudService<T extends BaseEntity, ID, C, U extends Identifiable> implements BaseCrudService<T, ID, C, U> {

    public abstract JpaRepository getRepository();

    public abstract MapperContract getMapper();

    @Autowired
    private EntityManager entityManager;

    public T save(C createRequest) {
        try {
            T entity = (T) getMapper().fromCreateDTO(createRequest);

            entity.setDataCriacao(LocalDateTime.now());

            validate(entity);
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

    public T update(U updateRequest) {
        try {
            Optional<T> optional = getRepository().findById(updateRequest.getId());

            if (optional.isEmpty()) {
                throw new RegistroNaoEncontradoException(updateRequest.getId());
            }

            T foundEntity = optional.get();
            getMapper().updateEntity(updateRequest, foundEntity);
            updateRelationships(updateRequest, foundEntity);

            beforeUpdate(foundEntity);
            validate(foundEntity);
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

    // Hooks methods

    public void validate(T entity) throws ServiceException {

    }

    public void beforeSave(T entity) {

    }

    public void afterSave(T entity) {

    }

    public void beforeUpdate(T entity) {

    }

    public void afterUpdate(T entity) {

    }

    public void updateRelationships(U updateRequest, T entity) {

    }

    // Getters and Setters

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
