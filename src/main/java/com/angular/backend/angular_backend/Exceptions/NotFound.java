package com.angular.backend.angular_backend.Exceptions;

public class NotFound extends RuntimeException {
    public static final long serialVersionUID =1L;

    public NotFound(String message) {
        super(message);
    }
}
