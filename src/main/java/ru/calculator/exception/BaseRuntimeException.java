package ru.calculator.exception;

public class BaseRuntimeException extends RuntimeException {

    private final String message;

    public BaseRuntimeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
