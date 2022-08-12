package br.com.personal.livia.domain.exception;

public abstract class CustomException extends RuntimeException {

    public CustomException(final String message) {
        super(message);
    }
}
