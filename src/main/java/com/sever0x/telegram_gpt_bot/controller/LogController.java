package com.sever0x.telegram_gpt_bot.controller;

import com.sever0x.telegram_gpt_bot.model.entity.MessageLog;
import com.sever0x.telegram_gpt_bot.service.MessageLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LogController {

    private final MessageLogService messageLogService;

    @GetMapping("/logs")
    public List<MessageLog> getLogs(@RequestParam(required = false) String chatId,
                                    @RequestParam(required = false) String username) {
        if (chatId != null) return messageLogService.getLogsByChatId(chatId);
        if (username != null) return messageLogService.getLogsByUsername(username);
        return messageLogService.getAllLogs();
    }
}
