package dev.fabricio.kofrinho.model;

import lombok.Getter;

@Getter
public enum TipoTransacaoEnum {

    DESPESA("Despesa"),
    RECEITA("Receita"),
    INVESTIMENTO("Investimento");

    private final String nome;

    TipoTransacaoEnum(String nome) {
        this.nome = nome;
    }
}
