package pringboot.carmanager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity handlerNotFound(){
        return ResponseEntity.notFound().build();
    }
}
