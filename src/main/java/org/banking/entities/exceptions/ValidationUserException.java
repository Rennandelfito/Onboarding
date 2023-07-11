package org.banking.entities.exceptions;

public class ValidationUserException extends RuntimeException {

    private String message;

    public ValidationUserException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
