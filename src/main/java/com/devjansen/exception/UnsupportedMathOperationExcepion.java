package com.devjansen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationExcepion extends RuntimeException {
    public UnsupportedMathOperationExcepion(String message) {
        super(message);
    }
}
