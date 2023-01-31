package com.example.restapi.restapi.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.restapi.restapi.dto.MessageDTO;

@RestControllerAdvice
public class ProductAdvice {
    

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageDTO processNullPointerException(NullPointerException exception){

        MessageDTO message = new MessageDTO();
        message.setMessage("Error found in request");
        message.setType("ERROR");
        
        return message;
    }
}
