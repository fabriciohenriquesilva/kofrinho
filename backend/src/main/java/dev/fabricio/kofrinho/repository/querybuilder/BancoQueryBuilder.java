package dev.fabricio.kofrinho.repository.querybuilder;

import dev.fabricio.kofrinho.controller.dto.banco.BancoFilterDTO;
import dev.fabricio.kofrinho.model.Banco;
import jakarta.persistence.EntityManager;

import java.util.List;

public class BancoQueryBuilder extends TinyQueryBuilder<Banco> {

    public BancoQueryBuilder(EntityManager entityManager) {
        super(entityManager);
    }

    public List<Banco> list(BancoFilterDTO filterDTO) {
        return from(Banco.class, "b")
                .andEquals("id", filterDTO.getId())
                .andEquals("nome", filterDTO.getNome())
                .andEquals("codigo", filterDTO.getCodigo())
                .andLike("nome", filterDTO.getNomeLike())
                .andBetween("id", filterDTO.getIdDe(), filterDTO.getIdAte())
                .build()
                .list(0, 100);
    }
}
