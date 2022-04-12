package org.zerock.guestbook.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
/**
 * @author Joo
 * @description
 *      DQCAT, Disa, Mariner 호출을 담당하는 서비스 로직
 */
public class TaRestCallBotServiceImpl {

    public void txService() {
        log.info("txService function");
    }

    public void rxService() {
        log.info("rxService function");
    }
}
