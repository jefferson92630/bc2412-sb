package com.bootcamp.demo.bc_forum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;

@RestControllerAdvice
public class GlobalExceptionHandler {
  
  @ExceptionHandler(value = UserNotFoundException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResult handleUserNotFound() {
    return new ErrorResult(1, "User not found.");
  }

  @ExceptionHandler(value = NumberFormatException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResult handleNumberFormatException() {
    return ErrorResult.builder() //
        .code(2) //
        .message("Invalid Input.") //
        .build();
  }

  @ExceptionHandler(value = RestClientException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResult handleRestClient() {
    return ErrorResult.builder()
    .code(3)
    .message("RestTemplate Error - JsonPlaceHolder")
    .build();
  }
}
