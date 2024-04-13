package dev.andreszapata.bankfuse.domain.exceptions;

public class CustomException extends RuntimeException {
    public CustomException(String ex) {
        super(ex);
    }
}
