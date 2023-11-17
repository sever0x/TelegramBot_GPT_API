package com.sever0x.telegram_gpt_bot.service.impl;

import com.sever0x.telegram_gpt_bot.model.request.auth.AuthRequest;
import com.sever0x.telegram_gpt_bot.model.response.auth.AuthResponse;
import com.sever0x.telegram_gpt_bot.repository.AdminRepository;
import com.sever0x.telegram_gpt_bot.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final JwtEncoder jwtEncoder;

    private final AdminRepository adminRepository;

    @Override
    public AuthResponse register(AuthRequest authRequest) {
        return null;
    }

    @Override
    public AuthResponse login(Authentication authentication) {
        String username = authentication.getName();

        var user = adminRepository.findByUsername(username).get();

        var now = Instant.now();
        var claims = JwtClaimsSet.builder()
                .issuer("spring")
                .issuedAt(now)
                .expiresAt(now.plus(30, ChronoUnit.MINUTES))
                .subject(username)
                .claim("id", user.getId())
                .build();

        log.error("Logged in = {}", username);

        return AuthResponse.builder()
                .jwtToken(jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue())
                .username(username)
                .build();
    }
}
