package it.tdgroup.eroi.controller;

import it.tdgroup.eroi.dto.rest.message.BaseResponse;
import it.tdgroup.eroi.exception.ApplicationException;
import it.tdgroup.eroi.exception.ServiceException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by p.b on 20/04/2017 11:10
 */
@ControllerAdvice
public class ExceptionHandlingController {

    private static final Log LOG = LogFactory.getLog(ExceptionHandlingController.class);

    @ExceptionHandler(value = {ApplicationException.class, ServiceException.class})
    public ResponseEntity<BaseResponse> resourceException(ApplicationException ex) {
        BaseResponse response = new BaseResponse();
        response.setStato(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        response.setDescrizione(ex.getMessage());
        return new ResponseEntity<BaseResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity error(MethodArgumentNotValidException ex) {
        ErrorJson response = new ErrorJson();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setError(fromBindingErrors(ex.getBindingResult()));
        response.setMessage("");
        response.setTimeStamp(new Date().toString());
        return new ResponseEntity<ErrorJson>(response, HttpStatus.BAD_REQUEST);
    }

    private String fromBindingErrors(Errors errors) {
        List<String> validErrors = new ArrayList<>();
        for (ObjectError objectError : errors.getAllErrors()) {
            validErrors.add(((FieldError) objectError).getField() + " " + objectError.getDefaultMessage());
        }
        return validErrors.toString();
    }


}
