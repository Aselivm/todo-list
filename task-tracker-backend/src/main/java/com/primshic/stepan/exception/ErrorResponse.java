package com.primshic.stepan.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorResponse extends RuntimeException{
    public ErrorResponse() {
        super();
    }

    public ErrorResponse(String message) {
        super(message);
    }

    public ErrorResponse(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorResponse(Throwable cause) {
        super(cause);
    }

    protected ErrorResponse(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
