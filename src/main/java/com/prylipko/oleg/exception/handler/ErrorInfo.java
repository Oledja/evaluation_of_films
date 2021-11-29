package com.prylipko.oleg.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ErrorInfo {
    private HttpStatus status;
    private Class exceptionClass;
    private String message;
}
