package br.com.personal.livia.domain.exception;

public class ClientException extends CustomException {
    public ClientException(String message) {
        super("Client error: " + message);
    }
}
