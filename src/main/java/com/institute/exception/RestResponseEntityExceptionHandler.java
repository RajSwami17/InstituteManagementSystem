package com.institute.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler 
{

    @ExceptionHandler(InstituteServiceCustomException.class)
    public ResponseEntity<ErrorResponse> handleInstituteServiceException(InstituteServiceCustomException isce) 
    {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorMessage(isce.getMessage());
        errorResponse.setErrorCode(isce.getErrorCode());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}

