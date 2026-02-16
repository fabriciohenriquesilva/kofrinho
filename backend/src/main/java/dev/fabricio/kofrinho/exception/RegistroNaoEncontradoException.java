package dev.fabricio.kofrinho.exception;

public class RegistroNaoEncontradoException extends RuntimeException {

    public RegistroNaoEncontradoException(String message) {
        super(message);
    }

    public RegistroNaoEncontradoException(Integer id) {
        super("Não foi possível localizar o registro com o ID: " + id);
    }
}
