package com.petproject.voting.util;

public class WrongDateOrTimeException extends RuntimeException {
    public WrongDateOrTimeException(String message) {
        super(message);
    }
}
