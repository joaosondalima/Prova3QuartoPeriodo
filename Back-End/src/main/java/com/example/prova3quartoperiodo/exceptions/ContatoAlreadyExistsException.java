package com.example.prova3quartoperiodo.exceptions;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ContatoAlreadyExistsException extends ServiceException{

    public ContatoAlreadyExistsException(String message) {super(message);}
}
