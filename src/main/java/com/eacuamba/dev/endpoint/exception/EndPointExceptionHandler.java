package com.eacuamba.dev.endpoint.exception;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@AllArgsConstructor
@ControllerAdvice
public class EndPointExceptionHandler extends ResponseEntityExceptionHandler {
    private MessageSource messagesource;

    @ExceptionHandler()
    public ResponseEntity<Object> handleEntidadeNaoEncontrada(EntidadeNaoEncontradaException e, WebRequest webRequest){
        HttpStatus status = HttpStatus.NOT_FOUND;
        ExceptionBody exceptionBody = new ExceptionBody();
        exceptionBody.setStatus(status.value());
        exceptionBody.setTitulo(e.getMessage());
        exceptionBody.setData(LocalDateTime.now());

        return handleExceptionInternal(e, exceptionBody, new HttpHeaders(), status, webRequest);
    }


}
