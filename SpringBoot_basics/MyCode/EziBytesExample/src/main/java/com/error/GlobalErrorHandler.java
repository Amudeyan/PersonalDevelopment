package com.error;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(annotations = RestController.class)
@Order(1)
@Slf4j
public class GlobalErrorHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Response response = new Response(status.value(),ex.getBindingResult().toString());
        log.error(response.toString());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler
    public ResponseEntity<Response> responseResponseEntity(Exception exception){
        Response response = new Response(500, exception.getMessage());
        log.error(response.toString());
        return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).body(response);
    }


}
