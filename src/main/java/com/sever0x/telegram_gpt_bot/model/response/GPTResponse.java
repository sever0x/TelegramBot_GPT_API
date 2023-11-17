package com.sever0x.telegram_gpt_bot.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GPTResponse {
    private String id;

    private String object;

    private long created;

    private String model;

    private List<Choice> choices;

    private Usage usage;
}
