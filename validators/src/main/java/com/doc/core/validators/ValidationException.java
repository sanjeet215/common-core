package com.doc.core.validators;

public class ValidationException extends BaseException {
    public ValidationException(String message) {
        super("VALIDATION_ERROR", message);
    }
}