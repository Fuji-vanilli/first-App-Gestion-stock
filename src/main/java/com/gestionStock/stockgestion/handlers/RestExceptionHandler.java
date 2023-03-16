package com.gestionStock.stockgestion.handlers;

import com.gestionStock.stockgestion.exception.EntityNotFoundException;
import com.gestionStock.stockgestion.exception.InvalidEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> handleException(EntityNotFoundException exception, WebRequest request){
        final HttpStatus notFound= HttpStatus.NOT_FOUND;
        final ErrorDto errorDto= ErrorDto.builder()
                .httpcode(notFound.value())
                .errorCode(exception.getErrorCode())
                .message(exception.getMessage())
                .build();

        return new ResponseEntity<>(errorDto, notFound);
    }

    public ResponseEntity<ErrorDto> handleException(InvalidEntityException exception, WebRequest request){
        final HttpStatus badRequest= HttpStatus.BAD_REQUEST;
        final ErrorDto errorDto= ErrorDto.builder()
                .httpcode(badRequest.value())
                .errorCode(exception.getErrorCode())
                .errors(exception.getErrors())
                .message(exception.getMessage())
                .build();

        return new ResponseEntity<>(errorDto, badRequest);
    }
}
