package com.botree.hackathon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception class for handling bad request.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor method.
     */
    public BadRequestException() {
        super();
    }

    /**
     * Constructor method.
     * @param message - error message
     */
    public BadRequestException(final String message) {
        super(message);
    }
}
