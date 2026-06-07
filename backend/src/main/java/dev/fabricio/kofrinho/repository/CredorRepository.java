package dev.fabricio.kofrinho.repository;

import dev.fabricio.kofrinho.model.Credor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredorRepository extends JpaRepository<Credor, Integer> {
}
