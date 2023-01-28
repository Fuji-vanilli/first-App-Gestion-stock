package com.gestionServer.gestionServer.exceptions;

import lombok.Getter;

import java.util.List;

public class InvalidEntityException extends RuntimeException{

    @Getter
    ErrorCode errorCode;
    @Getter
    List<String> errors;

    public InvalidEntityException(String messages){
        super(messages);
    }

    public InvalidEntityException(String messages, Throwable cause){
        super(messages, cause);
    }

    public InvalidEntityException(String messages, Throwable cause, ErrorCode errorCode){
        super(messages, cause);
        this.errorCode= errorCode;
    }

    public InvalidEntityException(String messages, ErrorCode errorCode, List<String> errors){
        super(messages);
        this.errorCode= errorCode;
        this.errors= errors;
    }

}
