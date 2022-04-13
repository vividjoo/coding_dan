package org.zerock.guestbook.common;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@Log4j2
public class TaRestCallBotException extends RuntimeException{
    public TaRestCallBotException(String errorMsg) {
        super(errorMsg);
    }
}
