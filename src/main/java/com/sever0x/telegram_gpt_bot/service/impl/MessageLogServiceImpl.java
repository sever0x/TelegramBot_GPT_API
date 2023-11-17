package com.sever0x.telegram_gpt_bot.service.impl;

import com.sever0x.telegram_gpt_bot.model.entity.MessageLog;
import com.sever0x.telegram_gpt_bot.repository.MessageLogRepository;
import com.sever0x.telegram_gpt_bot.service.MessageLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageLogServiceImpl implements MessageLogService {

    private final MessageLogRepository messageLogRepository;

    @Override
    public List<MessageLog> getAllLogs() {
        return messageLogRepository.findAll();
    }

    @Override
    public List<MessageLog> getLogsByChatId(String chatId) {
        return messageLogRepository.findByChatId(chatId);
    }

    @Override
    public List<MessageLog> getLogsByUsername(String username) {
        return messageLogRepository.findBySenderUsername(username);
    }
}
