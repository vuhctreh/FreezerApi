package com.northrow.api.exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorMessage {
    private final LocalDateTime date;
    private final String reason;
    private final HttpStatus status;

    public ErrorMessage(LocalDateTime date, String reason, HttpStatus status) {
        this.date = date;
        this.reason = reason;
        this.status = status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getReason() {
        return reason;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
