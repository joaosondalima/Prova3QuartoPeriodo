package com.example.prova3quartoperiodo.exceptions;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContatoNotFoundException extends ServiceException{

    public ContatoNotFoundException(String message) {
        super(message);
    }
}
