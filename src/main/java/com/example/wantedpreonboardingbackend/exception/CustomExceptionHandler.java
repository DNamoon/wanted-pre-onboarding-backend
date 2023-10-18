package com.example.wantedpreonboardingbackend.exception;

import com.example.wantedpreonboardingbackend.exception.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(AbstractException.class)
    protected ResponseEntity<ErrorResponseDto> handleCustomException(AbstractException exception) {
        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
            .statusCode(exception.getStatusCode())
            .data(exception.getData())
            .build();

        return new ResponseEntity<>(errorResponseDto, HttpStatus.resolve(exception.getStatusCode()));
    }
}
