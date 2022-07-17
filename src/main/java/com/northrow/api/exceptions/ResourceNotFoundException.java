package com.northrow.api.exceptions;

/**
 * The type ResourceNotFoundException.
 */
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Instantiates a new ResourceNotFoundException.
     *
     * @param message the message
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
