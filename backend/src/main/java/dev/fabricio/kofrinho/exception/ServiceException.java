package dev.fabricio.kofrinho.exception;

import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {

    private final String message;

    public ServiceException(String message) {
        super(message);
        this.message = message;
    }
}
