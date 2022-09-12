package com.botree.hackathon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class UnProcessableEntityException extends RuntimeException {

    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor method.
     */
    public UnProcessableEntityException() {
        super();
    }

    /**
     * Constructor method.
     * @param message - error message
     */
    public UnProcessableEntityException(final String message) {
        super(message);
    }
}
