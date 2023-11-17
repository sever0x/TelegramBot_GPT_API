package com.sever0x.telegram_gpt_bot.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
    private String role;
    private String content;
}
