package dev.andreszapata.bankfuse.domain.exceptions;

public class CustomException extends RuntimeException {
    public CustomException(String ex) {
        super(ex);
    }

    public CustomException(String ex, Exception e) {
        super(ex,e);
    }
}
