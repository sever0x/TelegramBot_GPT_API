package com.sever0x.telegram_gpt_bot.service;

import com.sever0x.telegram_gpt_bot.model.entity.MessageLog;

import java.util.List;

public interface MessageLogService {
    List<MessageLog> getAllLogs();

    List<MessageLog> getLogsByChatId(String chatId);

    List<MessageLog> getLogsByUsername(String username);
}
