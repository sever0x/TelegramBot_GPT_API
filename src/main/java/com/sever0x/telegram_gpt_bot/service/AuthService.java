package com.sever0x.telegram_gpt_bot.service;

import com.sever0x.telegram_gpt_bot.model.request.auth.AuthRequest;
import com.sever0x.telegram_gpt_bot.model.response.auth.AuthResponse;
import org.springframework.security.core.Authentication;

public interface AuthService {

    AuthResponse register(AuthRequest authRequest, boolean isSecretValid);

    AuthResponse login(Authentication authentication);
}
