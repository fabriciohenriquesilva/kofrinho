package dev.fabricio.kofrinho.common;

public interface BaseCrudService<T, ID> {

    T save(T entity);

    T findById(ID id);

    T update(T source);

    void delete(ID id);

}
