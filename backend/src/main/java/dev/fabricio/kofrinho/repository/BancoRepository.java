package dev.fabricio.kofrinho.repository;

import dev.fabricio.kofrinho.model.Banco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Integer> {

}
