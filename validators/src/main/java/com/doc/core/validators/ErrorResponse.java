package com.doc.core.validators;

import java.time.Instant;

public class ErrorResponse {
    private final String message;
    private final String code;
    private final Instant timestamp = Instant.now();

    public ErrorResponse(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() { return message; }
    public String getCode() { return code; }
    public Instant getTimestamp() { return timestamp; }
}