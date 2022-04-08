package com.ciklum.trendyol.exception;

import lombok.Getter;

/**
 * Custom converter exception
 */
@Getter
public class ConverterException extends RuntimeException {
    public ConverterException(String message) {
        super(message);
    }
}
