package com.sever0x.telegram_gpt_bot.config;

import com.sever0x.telegram_gpt_bot.bot.GoslingBot;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.concurrent.TimeUnit;

@Configuration
public class BotConfig {

    @Bean
    public TelegramBotsApi telegramBotsApi(GoslingBot goslingBot) throws TelegramApiException {
        var api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(goslingBot);
        return api;
    }

    @Bean
    public OkHttpClient httpClient() {
        return new OkHttpClient().newBuilder()
                .connectTimeout(180, TimeUnit.SECONDS)
                .writeTimeout(180, TimeUnit.SECONDS)
                .readTimeout(180, TimeUnit.SECONDS)
                .build();
    }
}
