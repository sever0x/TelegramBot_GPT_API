package com.sever0x.telegram_gpt_bot.controller;

import com.sever0x.telegram_gpt_bot.model.request.auth.AuthRequest;
import com.sever0x.telegram_gpt_bot.model.response.auth.AuthResponse;
import com.sever0x.telegram_gpt_bot.service.AuthService;
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

    @PostMapping("/admin/register")
    public AuthResponse register(@RequestBody @Valid AuthRequest authRequest) {
        return authService.register(authRequest);
    }

    @PostMapping("/admin/login")
    public AuthResponse login(Authentication authentication) {
        return authService.login(authentication);
    }
}
