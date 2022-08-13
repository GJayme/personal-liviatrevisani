package br.com.personal.livia.domain.exception;

public class SubscriptionException extends CustomException {
    public SubscriptionException(String message) {
        super("Subscription error: " + message);
    }
}
