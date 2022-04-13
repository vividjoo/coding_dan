package org.zerock.guestbook.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.zerock.guestbook.domain.TaRestCallBotResponseVO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
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

    @Valid
    @NotNull
    private List<TaRestCallBotResponseVO.Autocat> autocat;

    public static class Autocat {
        private String code;
        private String name;
    }
}
