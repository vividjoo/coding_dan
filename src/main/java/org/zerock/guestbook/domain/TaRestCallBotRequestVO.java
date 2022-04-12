package org.zerock.guestbook.domain;

import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * @author Joo 2022/04/07
 * @description
 *      CallBot Request DTO
 *      콜봇에서 넘어오는 데이터값들.
 *          - callId:
 *          - callText:
 *          - channel:
 *              ex:) tx, rx
 *          - sentence:
 *              ex:) '안녕하세요' , '반갑습니다.....'
 */
@Data
public class TaRestCallBotRequestVO {
    @NotNull
    private String callId;

    @NotNull
    @Valid
    private List<CallText> callText;

    @Data
    public static class CallText {
        @NotNull
        private String channel;
        @NotNull
        private String sentence;
    }
}