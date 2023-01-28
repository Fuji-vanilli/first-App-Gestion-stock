package com.gestionServer.gestionServer.handlers;

import com.gestionServer.gestionServer.exceptions.EntityNotFoundException;
import com.gestionServer.gestionServer.exceptions.InvalidEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleException(EntityNotFoundException exception, WebRequest webRequest){
        final HttpStatus notFound= HttpStatus.NOT_FOUND;
        final ErrorDTO errorDTO;

        errorDTO= ErrorDTO.builder()
                .code(exception.getErrorCode())
                .message(exception.getMessage())
                .statusCode(notFound.value())
                .build();

        return new ResponseEntity<>(errorDTO, notFound);
    }

    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<ErrorDTO> handleException(InvalidEntityException invalid, WebRequest webRequest){
        final HttpStatus badRequest= HttpStatus.BAD_REQUEST;
        final ErrorDTO errorDTO;

        errorDTO= ErrorDTO.builder()
                .code(invalid.getErrorCode())
                .message(invalid.getMessage())
                .statusCode(badRequest.value())
                .build();

        return new ResponseEntity<>(errorDTO, badRequest);
    }
}
