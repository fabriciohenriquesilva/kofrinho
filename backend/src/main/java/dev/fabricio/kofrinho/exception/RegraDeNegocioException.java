package dev.fabricio.kofrinho.exception;

import lombok.Getter;

@Getter
public class RegraDeNegocioException extends RuntimeException {

    private final String message;

    public RegraDeNegocioException(String message) {
        super(message);
        this.message = message;
    }
}
