package com.exception;

public class WordChainException extends Exception {
    public WordChainException() {
        super();
    }

    public WordChainException(String message) {
        super(message);
    }

    public WordChainException(String message, Throwable cause) {
        super(message, cause);
    }

    public WordChainException (Throwable cause) {
        super(cause);
    }
}
