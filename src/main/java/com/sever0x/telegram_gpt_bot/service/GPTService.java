package com.sever0x.telegram_gpt_bot.service;

import com.sever0x.telegram_gpt_bot.exception.ServiceException;

public interface GPTService {

    String getGPTResponse(String prompt) throws ServiceException;
}
