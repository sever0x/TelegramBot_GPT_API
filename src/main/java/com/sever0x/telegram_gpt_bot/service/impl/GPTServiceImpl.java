package com.sever0x.telegram_gpt_bot.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sever0x.telegram_gpt_bot.client.GPTClient;
import com.sever0x.telegram_gpt_bot.exception.ServiceException;
import com.sever0x.telegram_gpt_bot.model.entity.MessageLog;
import com.sever0x.telegram_gpt_bot.model.response.GPTResponse;
import com.sever0x.telegram_gpt_bot.repository.MessageLogRepository;
import com.sever0x.telegram_gpt_bot.service.GPTService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
@RequiredArgsConstructor
public class GPTServiceImpl implements GPTService {

    private final GPTClient client;

    private final MessageLogRepository messageLogRepository;

    @Override
    public String getGPTResponse(Message message, String prompt) throws ServiceException {
        try {
            String gptResponseValue = client.getGPTResponse(prompt);

            ObjectMapper objectMapper = new ObjectMapper();
            GPTResponse gptResponse = objectMapper.readValue(gptResponseValue, GPTResponse.class);

            String response = gptResponse.getChoices().get(0).getMessage().getContent();
            logMessage(message, response);
            return response;
        } catch (Exception e) {
            throw new ServiceException("An error occurred while accessing GPT", e);
        }
    }

    private void logMessage(Message message, String response) {
        long timestampInSeconds = message.getDate();
        Instant instant = Instant.ofEpochSecond(timestampInSeconds);
        LocalDateTime messageTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

        MessageLog messageLog = MessageLog.builder()
                .chatId(message.getChatId().toString())
                .senderUsername(message.getChat().getUserName())
                .senderMessage(message.getText())
                .responseMessage(response)
                .time(messageTime)
                .build();
        messageLogRepository.save(messageLog);
    }
}