package dev.fabricio.kofrinho.common;

import dev.fabricio.kofrinho.exception.ServiceException;
import org.springframework.beans.BeanUtils;

public abstract class BaseMapper<E, ID, C, U, R> {

    private final Class<E> entityClass;
    private final Class<R> responseClass;

    protected BaseMapper(Class<E> entityClass, Class<R> responseClass) {
        this.entityClass = entityClass;
        this.responseClass = responseClass;
    }

    protected abstract BaseCrudService<E, ID> getService();

    public E toEntityFromCreateRequest(C dto) {
        if (dto == null) {
            return null;
        }

        try {
            E entity = entityClass.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(dto, entity);
            return entity;
        } catch (ReflectiveOperationException e) {
            throw new ServiceException("Erro ao mapear o DTO para Entidade: " + e.getMessage());
        }
    }

    public E toEntityFromUpdateRequest(U dto) {
        if (dto == null) {
            return null;
        }

        try {
            E entity = entityClass.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(dto, entity);
            return entity;
        } catch (ReflectiveOperationException e) {
            throw new ServiceException("Erro ao mapear o DTO para Entidade: " + e.getMessage());
        }
    }

    public R toDTO(E entity) {
        if (entity == null) {
            return null;
        }

        try {
            R dto = responseClass.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(entity, dto);
            return dto;
        } catch (ReflectiveOperationException e) {
            throw new ServiceException("Erro ao mapear a Entidade para DTO: " + e.getMessage());
        }
    }

    public E fromId(ID id) {
        return getService().findById(id);
    }

}
