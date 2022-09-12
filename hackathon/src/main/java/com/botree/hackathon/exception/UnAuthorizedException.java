package com.botree.hackathon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnAuthorizedException extends RuntimeException {

    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor method.
     */
    public UnAuthorizedException() {
        super();
    }

    /**
     * Constructor method.
     * @param message - error message
     */
    public UnAuthorizedException(final String message) {
        super(message);
    }

}
