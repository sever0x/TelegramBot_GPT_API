package com.sever0x.telegram_gpt_bot.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Choice {
    private long index;

    private Message message;

    @JsonProperty("finish_reason")
    private String finishReason;
}
