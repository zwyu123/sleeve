package com.lin.sleeve.exception.http;

public class NotFoundException extends HttpException {

    public NotFoundException(String message) {
        super(message);
        this.httpStatusCode = 404;
    }
}
