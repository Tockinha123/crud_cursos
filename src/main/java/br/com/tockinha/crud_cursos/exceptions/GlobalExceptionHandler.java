package br.com.tockinha.crud_cursos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, List<String>>>
    handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .toList();

        return new ResponseEntity<>(getErrosMap(errors), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, List<String>>>
    handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        List<String> error = List.of("This field only accepts the following values: ACTIVE or INACTIVE.");

        return new ResponseEntity<>(getErrosMap(error), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CourseNotFoundException.class)
    ResponseEntity<Map<String, List<String>>>
    handleCourseNotFoundException(CourseNotFoundException ex){
        List<String> error = List.of(ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getErrosMap(error));
    }

    private Map<String, List<String>> getErrosMap(List<String> errors){

        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        return errorResponse;
    }
}