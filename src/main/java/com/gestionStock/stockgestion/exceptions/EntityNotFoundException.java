package com.gestionStock.stockgestion.exceptions;

import lombok.Getter;

public class EntityNotFoundException extends RuntimeException{

    @Getter
    private ErrorCode errorCode;

    public EntityNotFoundException(String messages){
        super(messages);
    }

    public EntityNotFoundException(String messages, Throwable cause){
        super(messages, cause);
    }

    public EntityNotFoundException(String messages, Throwable cause, ErrorCode errorCode){
        super(messages, cause);
        this.errorCode= errorCode;
    }

    public EntityNotFoundException(String messages, ErrorCode errorCode){
        super(messages);
        this.errorCode= errorCode;
    }
}