package com.sever0x.telegram_gpt_bot.model.request.admin;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record MessageRequest(
        @NotNull
        @NotEmpty
        String chatId,

        @NotNull
        @NotEmpty
        String message
) {
}
