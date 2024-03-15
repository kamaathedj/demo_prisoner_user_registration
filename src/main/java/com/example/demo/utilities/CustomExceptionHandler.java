package com.example.demo.utilities;

import jakarta.servlet.ServletException;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.xml.sax.ErrorHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class CustomExceptionHandler {
    //fixme: fix this exception handling thingy :)

    @ExceptionHandler
    public Exception handle(ServletException exception){
        return new Exception("your things are not here "+ exception.getMessage());
    }
}
