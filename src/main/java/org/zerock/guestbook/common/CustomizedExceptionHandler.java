package org.zerock.guestbook.common;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.zerock.guestbook.controller.TaRestCallBotController;

import java.util.Date;

@RestController
@ControllerAdvice
@Log4j2
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> callBotException(Exception e, WebRequest request) {
        ExceptionResponse exceptionResponse = null;
        if("empty".equals(e.getMessage())) {
            exceptionResponse = new ExceptionResponse(900, e.getMessage(), "empty", null, null, null);
        }else if("null".equals(e.getMessage())){
            exceptionResponse = new ExceptionResponse(902, e.getMessage(), "null", null, null, null);
        }else{
            exceptionResponse = new ExceptionResponse(999, e.getMessage(), "null", null, null, null);
        }
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
