package com.cashion.dog.dogservices.common.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    public static final Log LOG = LogFactory.getLog(GlobalExceptionHandler.class);

    public ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex,
                                                               final HttpHeaders headers,
                                                               final HttpStatus status,
                                                               final WebRequest request) {
        CommonError error = CommonErrorBuilder.fromBindingErrors(ex.getBindingResult());
        return super.handleExceptionInternal(ex, error, headers, status, request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleInternalServerException(Exception e) {
        LOG.error("An internal error occurred: " + e.getMessage(), e);

        String genericErrorMessage = "An unexpected error occurred. Please try again later.";
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(genericErrorMessage);
    }

    @ExceptionHandler(BreedNotFoundException.class)
    public ResponseEntity<Object> handleBreedNotFoundException(BreedNotFoundException ex) {
        LOG.error("Breed not found exception: ", ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(DogBreedAlreadyExistsException.class)
    public ResponseEntity<Object> handleDogBreedAlreadyExistsException(DogBreedAlreadyExistsException ex) {
        LOG.error("Dog breed already exists exception: ", ex);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }
}
