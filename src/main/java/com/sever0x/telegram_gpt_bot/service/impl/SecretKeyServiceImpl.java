package com.sever0x.telegram_gpt_bot.service.impl;

import com.sever0x.telegram_gpt_bot.model.entity.SecretKey;
import com.sever0x.telegram_gpt_bot.repository.SecretKeyRepository;
import com.sever0x.telegram_gpt_bot.service.SecretKeyService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SecretKeyServiceImpl implements SecretKeyService {

    private final SecretKeyRepository secretKeyRepository;

    @PostConstruct
    public void init() {
        SecretKey key = secretKeyRepository.findById(1)
                .orElseGet(this::generateAndSaveSecretKey);

        key.setSecret(generateRandomSecret());
        secretKeyRepository.save(key);
    }

    @Override
    public String updateSecret() {
        SecretKey key = getSecretKey();
        key.setSecret(generateRandomSecret());
        secretKeyRepository.save(key);
        return key.getSecret();
    }

    @Override
    public boolean checkSecret(String secret) {
        return secretKeyRepository.existsBySecret(secret);
    }

    private SecretKey getSecretKey() {
        return secretKeyRepository.findById(1)
                .orElseThrow();
    }

    private String generateRandomSecret() {
        return UUID.randomUUID().toString();
    }

    private SecretKey generateAndSaveSecretKey() {
        SecretKey key = new SecretKey();
        key.setSecret(generateRandomSecret());
        return secretKeyRepository.save(key);
    }
}
