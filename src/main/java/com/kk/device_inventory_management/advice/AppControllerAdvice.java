package com.kk.device_inventory_management.advice;

import java.util.Set;
import java.util.stream.Collectors;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.kk.device_inventory_management.Exception.ErrorMessage;
import com.kk.device_inventory_management.Exception.NoRecordsException;

@ControllerAdvice
@Component
public class AppControllerAdvice {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolationExceptions(@NotNull ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        return new ResponseEntity<>(new ErrorMessage(constraintViolations.stream().map(constraintViolation -> constraintViolation.getMessage()).collect(Collectors.toList()).get(0)), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoRecordsException.class)
    public ResponseEntity<?> handleNoRecordsException(@NotNull NoRecordsException ex) {
        return new ResponseEntity<>(new ErrorMessage(ex.getMessage()), HttpStatus.NOT_FOUND);
    }
}


