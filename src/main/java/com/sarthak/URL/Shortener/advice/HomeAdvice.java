package com.sarthak.URL.Shortener.advice;

import com.sarthak.URL.Shortener.dto.ErrorApi;
import com.sarthak.URL.Shortener.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class HomeAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleInvalidArgument(MethodArgumentNotValidException ex){
        Map<String,String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach( error ->{
            errorMap.put(error.getField(),error.getDefaultMessage());
        });
        return errorMap;
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorApi handleNotFound(NotFoundException ex){

        ErrorApi errorApi = new ErrorApi();
        errorApi.setDate(new Date());
        errorApi.setType("UNAUTHORIZED");
        errorApi.setStatusCode(HttpStatus.UNAUTHORIZED.value());
        errorApi.setMessage(ex.getMessage());

        return errorApi;
    }

}
