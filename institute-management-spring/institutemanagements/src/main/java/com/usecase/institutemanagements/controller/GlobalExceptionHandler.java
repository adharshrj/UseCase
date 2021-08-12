package com.usecase.institutemanagements.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.usecase.institutemanagements.model.ErrorCust;
import com.usecase.institutemanagements.model.ErrorModel;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler(value = ErrorCust.class)
    public ResponseEntity<ErrorModel> exception(ErrorCust ec, WebRequest we){
    	ErrorModel ec1 = new ErrorModel();
        ec1.setErrorCode(ec.getErrorCode());
        ec1.setErrorMessage(ec.getErrorMsg());
        return new ResponseEntity<ErrorModel>(ec1, HttpStatus.NOT_FOUND);
    }


}