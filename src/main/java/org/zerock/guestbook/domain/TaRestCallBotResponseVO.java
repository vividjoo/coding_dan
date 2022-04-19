package org.zerock.guestbook.domain;

import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
//@Bu
// ilder
public class TaRestCallBotResponseVO {
//    public TaRestCallBotResponseVO(int resultCode, String errorMsg, String callId, List<String> summary, List<String> keyword,
//                            List<Autocat> autocats){
//        this.resultCode = resultCode;
//        this.errorMsg = errorMsg;
//        this.callId = callId;
//        this.summary = summary;
//        this.keyword = keyword;
//        this.autocat = autocats;
//    }
    /**
     * @author Joo 2022.04.11
     * @description
     *      resultCode: 상태코드
     *          - 200 성공
     *          - 990 Param error (RequestBody에 정보가 없을 때)
     *          - 992 Data 없음 (callId가 없을 때, 1) 빈칸인 경우 2) callId값이 null인 경우)
     *          - 993 TA분석 오류(disa, mariner, topicker, DQCAT)
     *          - 999 그 외 오류
     *      errorMsg: 오류 내용
     *          - 오류가 없을 시 N/A를 그대로 리턴함
     *          - 오류가 있을 시 오류 내용을 담아 상태코드와 함께 리턴
     *      callId: sessionId와 동일
     *          - Request에서 오는 callid와 동일
     *      summary: 문장 요약
     *      keyword: 요약 된 문장에서 나온 키워드
     *      autocat
     *          - code: 대분류, 소분류 분류 등으로 나눔
     *          - name: 위의 분류를 대, 중, 소 로 나눔
     *      event: 이벤트
     */

    @NotNull
    private int resultCode;
    @NotNull
    private String errorMsg = "N/A";
    @NotNull
    private String callId;
    @NotNull
    private List<String> summary;
    @NotNull
    private List<String> keyword;

    @NotNull
    private List<String> event;

    @Valid
    @NotNull
    private List<Autocat> autocat;

    public static class Autocat {
        private String code;
        private String name;
    }

//    public static class TaRestCallBotResponseVOBuilder {
//    }
}
