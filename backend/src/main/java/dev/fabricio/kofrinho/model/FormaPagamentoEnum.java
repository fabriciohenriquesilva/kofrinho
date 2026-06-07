package dev.fabricio.kofrinho.model;

import lombok.Getter;

@Getter
public enum FormaPagamentoEnum {

    PIX("PIX"),
    DINHEIRO("Dinheiro"),
    CREDITO("Crédito"),
    DEBITO("Débito"),
    CHEQUE("Cheque");

    private final String nome;

    FormaPagamentoEnum(String nome) {
        this.nome = nome;
    }
}
