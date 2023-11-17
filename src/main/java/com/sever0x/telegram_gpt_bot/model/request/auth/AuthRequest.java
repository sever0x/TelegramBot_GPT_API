package com.sever0x.telegram_gpt_bot.model.request.auth;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record AuthRequest(
        @NotNull
        @NotEmpty
        @Min(3)
        String username,

        @NotNull
        @NotEmpty
        @Min(6)
        String password
) {
}
