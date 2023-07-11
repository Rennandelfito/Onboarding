package org.banking.controller.handler;

import org.banking.entities.exceptions.ApiError;
import org.banking.entities.exceptions.ValidationUserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(ValidationUserException.class)
    public ResponseEntity<ApiError> errorUserValidation(ValidationUserException ex){
        ApiError response = new ApiError(ex.getMessage(), HttpStatus.BAD_REQUEST);
        return ResponseEntity.badRequest().body(response);
    }
}
