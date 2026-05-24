package dev.fabricio.kofrinho.common;

public interface BaseCrudService<T, ID, C, U extends Identifiable> {

    T save(C createRequest);

    T findById(ID id);

    T update(U updateRequest);

    void delete(ID id);

}
