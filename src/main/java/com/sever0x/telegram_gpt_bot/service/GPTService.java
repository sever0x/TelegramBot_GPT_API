package com.sever0x.telegram_gpt_bot.service;

import com.sever0x.telegram_gpt_bot.exception.ServiceException;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface GPTService {

    String getGPTResponse(Message message, String prompt) throws ServiceException;
}
