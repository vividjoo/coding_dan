package org.zerock.guestbook.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.zerock.guestbook.common.TaRestCallBotException;
import org.zerock.guestbook.domain.TaRestCallBotRequestVO;
import org.zerock.guestbook.domain.TaRestCallBotResponseVO;
import org.zerock.guestbook.service.TaRestCallBotServiceImpl;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/restapi")
@Log4j2
@RequiredArgsConstructor
public class TaRestCallBotController {

    private final TaRestCallBotServiceImpl callBotServiceImpl;


    /**
     * @param callBotVO TaRestCallBotVO 참조
     * @author Joo 2022/04/08
     * @description CallBot에서 실시간으로 상담원과 고객의 대화의 내용들이 넘어온다.
     * 해당 controller는 실시간으로 넘어오는 문장(대화 내용)을 처음으로 받는 controller이다.
     */
    @PostMapping("/callbot")
    public TaRestCallBotResponseVO callbot(@RequestBody TaRestCallBotRequestVO callBotVO) {
        TaRestCallBotResponseVO taRestCallBotResponseVO = new TaRestCallBotResponseVO();
        if ("".equals(callBotVO.getCallId())) {
            throw new TaRestCallBotException("empty");
        } else if (callBotVO.getCallId() == null) {
            throw new TaRestCallBotException("null");
        } else {
            taRestCallBotResponseVO.setResultCode(200);
            taRestCallBotResponseVO.setCallId(callBotVO.getCallId());
            taRestCallBotResponseVO.setSummary(Arrays.asList("123","zcxvzcv"));
        }
        return taRestCallBotResponseVO;
    }

    @GetMapping("/test")
    public void test() {
        log.info("hello world!");
    }

    @PostMapping("/index")
    public Map<String, String> result(@RequestBody TaRestCallBotRequestVO callBotRequestVO) {
        Map<String, String> response = new HashMap<>();
        log.info(callBotRequestVO.toString());

        return null;
    }
}
