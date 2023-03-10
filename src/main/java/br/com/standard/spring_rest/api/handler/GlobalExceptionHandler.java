package br.com.standard.spring_rest.api.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.standard.spring_rest.domain.dto.ErrorMessage;
import br.com.standard.spring_rest.domain.exception.NotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(value = NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorMessage handle(NotFoundException ex) {
        return new ErrorMessage(HttpStatus.NOT_FOUND.value(), "Not Found!");
    }
}
