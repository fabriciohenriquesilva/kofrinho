package dev.fabricio.kofrinho.model;

import lombok.Getter;

/**
 * @deprecated
 */

@Getter
public enum TipoPagamento {

    A_VISTA("À vista"),
    PARCELADO("Parcelado");

    private final String nome;

    TipoPagamento(String nome) {
        this.nome = nome;
    }

}
