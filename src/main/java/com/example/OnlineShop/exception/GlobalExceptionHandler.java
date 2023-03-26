package com.example.OnlineShop.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({UnsafeNewPassword.class, Custom.class})
    public ResponseEntity<?> handleException(RuntimeException e){
        Map<String, String> responseParameters = new HashMap<>();
        responseParameters.put("Message: ", e.getMessage());
        return ResponseEntity.badRequest().body(responseParameters);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleHibernateObjectValidation(MethodArgumentNotValidException exception){
        Map<String, Object> responseParameters = new HashMap<>();
        List<String> errors = exception.getBindingResult().getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        responseParameters.put("Messages: ", errors);

        return ResponseEntity.badRequest().body(responseParameters);
    }
}
