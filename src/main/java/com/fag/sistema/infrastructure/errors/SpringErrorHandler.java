package com.fag.sistema.infrastructure.errors;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class SpringErrorHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Object> handle400Error(MethodArgumentNotValidException exception) {

    List<FieldError> errorsList = exception.getFieldErrors();

    return ResponseEntity.badRequest().body(errorsList);
  }

  @ExceptionHandler(ArithmeticException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<CustomErrorResponse> handleInvalidParamError(ArithmeticException exception,
      WebRequest request) {

    CustomErrorResponse response = new CustomErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),
        exception.getMessage());

    return new ResponseEntity<CustomErrorResponse>(response, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(RuntimeException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<CustomErrorResponse> handleRuntimeException(RuntimeException exception) {

    CustomErrorResponse response = new CustomErrorResponse(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
        exception.getMessage());

    return new ResponseEntity<CustomErrorResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> handle500Error(Exception ex) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + ex.getLocalizedMessage());
  }
}
