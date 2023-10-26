package br.com.ismyburguer.core.adapter.in;

import br.com.ismyburguer.core.exception.BusinessException;
import br.com.ismyburguer.core.exception.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.util.Random;
import java.util.Set;

@RestControllerAdvice
class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)  // 404
    @ExceptionHandler(EntityNotFoundException.class)
    ProblemDetail handleEntityNotFoundException(EntityNotFoundException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
        problemDetail.setTitle(e.getMessage());
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)  // 422
    @ExceptionHandler(BusinessException.class)
    ProblemDetail businessException(BusinessException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
        problemDetail.setTitle(e.getMessage());
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)  // 422
    @ExceptionHandler(ConstraintViolationException.class)
    ProblemDetail handleConstraintViolationException(ConstraintViolationException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        problemDetail.setTitle("Erro ao validar estrutura de dados");

        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        if(constraintViolations != null) {
            constraintViolations
                    .forEach(constraintViolation -> {
                        Path propertyPath = constraintViolation.getPropertyPath();
                        String message = constraintViolation.getMessage();
                        problemDetail.setProperty(propertyPath.toString(), message);
                    });
        } else {
            problemDetail.setDetail(e.getLocalizedMessage());
        }

        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }

}