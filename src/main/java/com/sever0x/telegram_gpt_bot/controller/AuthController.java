package com.sever0x.telegram_gpt_bot.controller;

import com.sever0x.telegram_gpt_bot.model.request.auth.AuthRequest;
import com.sever0x.telegram_gpt_bot.model.response.auth.AuthResponse;
import com.sever0x.telegram_gpt_bot.service.AuthService;
import com.sever0x.telegram_gpt_bot.service.SecretKeyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    private final SecretKeyService secretKeyService;

    @PostMapping("/admin/register")
    public AuthResponse register(@RequestBody @Valid AuthRequest authRequest) {
        AuthResponse authResponse = authService.register(authRequest,
                secretKeyService.checkSecret(authRequest.secret()));
        secretKeyService.updateSecret();

        return authResponse;
    }

    @PostMapping("/admin/login")
    public AuthResponse login(Authentication authentication) {
        return authService.login(authentication);
    }
}
