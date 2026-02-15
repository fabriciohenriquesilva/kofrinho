package dev.fabricio.kofrinho.model;

import lombok.Getter;

@Getter
public enum TipoTransacao {

    DEPESA("Despesa"),
    RECEITA("Receita"),
    INVESTIMENTO("Investimento");

    private final String nome;

    TipoTransacao(String nome) {
        this.nome = nome;
    }
}
