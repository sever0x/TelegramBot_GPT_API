package com.sever0x.telegram_gpt_bot.model.response.auth;

import lombok.Builder;

@Builder
public record AuthResponse(
        String username,

        String jwtToken
) {
}
