package com.sever0x.telegram_gpt_bot.service;

import com.sever0x.telegram_gpt_bot.exception.ServiceException;
import com.sever0x.telegram_gpt_bot.model.request.auth.AuthRequest;
import com.sever0x.telegram_gpt_bot.model.response.auth.AuthResponse;
import org.springframework.security.core.Authentication;

public interface AdminService {

    AuthResponse register(AuthRequest authRequest, boolean isSecretValid);

    AuthResponse login(Authentication authentication);

    void sendCustomMessage(String chatId, String message) throws ServiceException;
}
