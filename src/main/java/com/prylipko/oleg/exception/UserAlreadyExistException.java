package com.prylipko.oleg.exception;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String userName) {
        super(String.format("User '%s' already exist", userName));
    }
}
