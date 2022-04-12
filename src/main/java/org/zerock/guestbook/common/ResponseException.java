package org.zerock.guestbook.common;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.zerock.guestbook.domain.TaRestCallBotRequestVO;
import org.zerock.guestbook.domain.TaRestCallBotResponseVO;

import java.util.List;


@Component
@Log4j2
public class ResponseException implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        log.info("3");
        return TaRestCallBotRequestVO.class.isAssignableFrom(TaRestCallBotRequestVO.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        log.info("4");
        TaRestCallBotRequestVO requestVO = (TaRestCallBotRequestVO) target;
        String callId = requestVO.getCallId();
        log.info("callId : "+requestVO.getCallId());
        log.info("ㄹㅇㅁㄹ " +requestVO.getCallText().get(0).getSentence());

        if ("".equals(requestVO.getCallId())) {
            try {
                throwTaRestCallBotResponseVO(990, "callId is empty", "callId", null, null, null);
            } catch (TaRestCallBotResponseVO e) {
                e.printStackTrace();
            }
        } else if (requestVO.getCallId() == null) {
            try {
                throwTaRestCallBotResponseVO(992, "callId is null", "callId", null, null, null);
            } catch (TaRestCallBotResponseVO e) {
                e.printStackTrace();
            }
        }
        else{
            log.info("else !");
            try {
                throwTaRestCallBotResponseVO(999, "etc error!", "callId", null, null, null);
            } catch (TaRestCallBotResponseVO e) {
                e.printStackTrace();
            }
        }
    }

    public void throwTaRestCallBotResponseVO(int resultCode, String errrorMsg, String callId, List<String> summary,
                                             List<String> keyword, List<TaRestCallBotResponseVO.Autocat> autocat) throws TaRestCallBotResponseVO {
        throw new TaRestCallBotResponseVO(resultCode, errrorMsg, callId, summary, keyword, autocat);
    }
}
