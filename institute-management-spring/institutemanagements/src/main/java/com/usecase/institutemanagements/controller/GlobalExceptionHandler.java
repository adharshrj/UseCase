package com.usecase.institutemanagements.controller;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.lang.*;
import java.util.*;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import com.usecase.institutemanagements.model.*;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler(value = ErrorCust.class)
    public ResponseEntity<ErrorModel> exception(ErrorCust ec, WebRequest we){
    	ErrorModel ec1 = new ErrorModel();
        ec1.setErrorCode(ec.getErrorCode());
        ec1.setErrorMessage(ec.getErrorMsg());
        System.err.println("Errors Occured" + ec.toString());
        return new ResponseEntity<ErrorModel>(ec1, HttpStatus.NOT_FOUND);
    }


}