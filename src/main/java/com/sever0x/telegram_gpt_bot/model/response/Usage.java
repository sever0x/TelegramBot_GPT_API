package com.sever0x.telegram_gpt_bot.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usage {
    @JsonProperty("prompt_tokens")
    private long promptTokens;

    @JsonProperty("completion_tokens")
    private long completionTokens;

    @JsonProperty("total_tokens")
    private long totalTokens;
}