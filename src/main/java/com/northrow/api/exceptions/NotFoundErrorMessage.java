package com.northrow.api.exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * The type "NotFoundErrorMessage".
 */
public class NotFoundErrorMessage {
    private final LocalDateTime date;
    private final String reason;
    private final HttpStatus status;

    /**
     * Instantiates a new "NotFoundErrorMessage".
     *
     * @param date   the date
     * @param reason the reason
     * @param status the status
     */
    public NotFoundErrorMessage(LocalDateTime date, String reason, HttpStatus status) {
        this.date = date;
        this.reason = reason;
        this.status = status;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Gets reason.
     *
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public HttpStatus getStatus() {
        return status;
    }
}
