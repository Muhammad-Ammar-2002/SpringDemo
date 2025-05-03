package com.SpringDemo.Exceptions;

import lombok.Setter;

@Setter
public class DuplicateRecordException extends RuntimeException {

    String message;
    public DuplicateRecordException(String userAlreadyExists) {
        super(userAlreadyExists);
        this.message = userAlreadyExists;
    }
}
