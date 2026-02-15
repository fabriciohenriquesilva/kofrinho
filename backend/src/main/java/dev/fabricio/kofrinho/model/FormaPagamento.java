package dev.fabricio.kofrinho.model;

import lombok.Getter;

@Getter
public enum FormaPagamento {

    PIX("PIX"),
    DINHEIRO("Dinheiro"),
    CREDITO("Crédito"),
    DEBITO("Débito"),
    CHEQUE("Cheque");

    private final String nome;

    FormaPagamento(String nome) {
        this.nome = nome;
    }
}
