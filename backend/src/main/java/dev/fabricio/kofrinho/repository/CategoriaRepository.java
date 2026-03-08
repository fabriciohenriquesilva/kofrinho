package dev.fabricio.kofrinho.repository;

import dev.fabricio.kofrinho.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    List<Categoria> findCategoriaByCodigo(String codigo);

}
