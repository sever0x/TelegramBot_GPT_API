package com.sever0x.telegram_gpt_bot.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sever0x.telegram_gpt_bot.client.GPTClient;
import com.sever0x.telegram_gpt_bot.exception.ServiceException;
import com.sever0x.telegram_gpt_bot.model.response.GPTResponse;
import com.sever0x.telegram_gpt_bot.service.GPTService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GPTServiceImpl implements GPTService {

    private final GPTClient client;

    @Override
    public String getGPTResponse(String prompt) throws ServiceException {
        try {
            String gptResponseValue = client.getGPTResponse(prompt);

            ObjectMapper objectMapper = new ObjectMapper();
            GPTResponse gptResponse = objectMapper.readValue(gptResponseValue, GPTResponse.class);

            return gptResponse.getChoices().get(0).getMessage().getContent();
        } catch (Exception e) {
            throw new ServiceException("An error occurred while accessing GPT", e);
        }
    }
}