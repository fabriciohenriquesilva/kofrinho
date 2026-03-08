package dev.fabricio.kofrinho.common;

import dev.fabricio.kofrinho.exception.RegistroNaoEncontradoException;
import dev.fabricio.kofrinho.exception.ServiceException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@SuppressWarnings("unchecked")
public abstract class AbstractCrudService<T extends BaseEntity, ID, C, U extends Updatable> implements BaseCrudService<T, ID, C, U> {

    public abstract JpaRepository getRepository();

    public abstract BaseMapper getMapper();

    private RelationshipResolver relationshipResolver;

    public T save(C createRequest) {
        try {
            T entity = (T) getMapper().toEntity(createRequest);

            entity.setDataCriacao(LocalDateTime.now());

            relationshipResolver.execute(entity, createRequest);

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
            Optional<T> findById = getRepository().findById(updateRequest.getId());

            if (findById.isEmpty()) {
                throw new RegistroNaoEncontradoException(updateRequest.getId());
            }

            T foundEntity = findById.get();

            relationshipResolver.execute(foundEntity, updateRequest);

            validate(foundEntity);
            beforeUpdate(foundEntity);

            BeanUtils.copyProperties(updateRequest, foundEntity, "id", "dataCriacao", "version");
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

    @Autowired()
    public void setRelationshipResolver(RelationshipResolver relationshipResolver) {
        this.relationshipResolver = relationshipResolver;
    }
}
