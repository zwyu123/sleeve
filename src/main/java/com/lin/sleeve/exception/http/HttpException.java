package com.lin.sleeve.exception.http;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HttpException extends RuntimeException {
    protected Integer httpStatusCode = 500;

    public HttpException(String message) {
        super(message);
    }
}
