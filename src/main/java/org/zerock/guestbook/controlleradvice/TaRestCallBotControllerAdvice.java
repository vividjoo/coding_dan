package org.zerock.guestbook.controlleradvice;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.zerock.guestbook.common.ResponseException;
import org.zerock.guestbook.controller.TaRestCallBotController;
import org.zerock.guestbook.domain.TaRestCallBotResponseVO;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@RestControllerAdvice(assignableTypes = TaRestCallBotController.class)
public class TaRestCallBotControllerAdvice {
    private ResponseException responseException;

    @Autowired
    TaRestCallBotControllerAdvice(ResponseException responseException) {
        this.responseException = responseException;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
//        webDataBinder.bind((PropertyValues) responseException);
        log.info("1");
        webDataBinder.setValidator(new ResponseException());
        log.info("2");
    }

    @ExceptionHandler(Exception.class)
    public TaRestCallBotResponseVO.TaRestCallBotResponseVOBuilder badRequest(ResponseException responseException, HttpServletRequest request) {
        TaRestCallBotResponseVO.TaRestCallBotResponseVOBuilder responseVO = TaRestCallBotResponseVO.builder().resultCode(993)
                .callId("").errorMsg("callId is empty !").summary(null).keyword(null).autocat(null);
//        return (ResponseEntity<TaRestCallBotResponseVO>) ResponseEntity.status(993).body(responseVO);
        return responseVO;
    }
}
