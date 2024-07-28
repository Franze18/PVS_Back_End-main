package com.pvsbackend.pvs.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pvsbackend.pvs.NotFoundException.NameRequestNotFoundException;

@RestControllerAdvice
public class NameRequestExceptionHandler {

    @ExceptionHandler(NameRequestNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String nameRequestNotFoundHandler(NameRequestNotFoundException e){
        return e.getMessage();
    }
}
