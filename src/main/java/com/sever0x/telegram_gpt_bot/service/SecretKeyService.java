package com.sever0x.telegram_gpt_bot.service;

public interface SecretKeyService {

    String updateSecret();

    boolean checkSecret(String secret);
}
