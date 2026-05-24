package dev.fabricio.kofrinho.common;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public abstract class AbstractController<E extends BaseEntity, ID, C, U extends Identifiable, R> {

    protected abstract BaseCrudService<E, ID, C, U> getService();

    protected abstract MapperContract<E, C, U, R> getMapper();

    @PostMapping
    public ResponseEntity<R> create(@Valid @RequestBody C request) {
        E entity = getService().save(request);
        R response = getMapper().toReponse(entity);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entity.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<R> findById(@PathVariable ID id) {
        E entity = getService().findById(id);
        R response = getMapper().toReponse(entity);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<R> update(@Valid @RequestBody U request) {
        E entity = getService().update(request);
        R response = getMapper().toReponse(entity);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        getService().delete(id);
        return ResponseEntity.noContent().build();
    }
}
