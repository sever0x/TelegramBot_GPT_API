package com.sever0x.telegram_gpt_bot.controller;

import com.sever0x.telegram_gpt_bot.exception.ServiceException;
import com.sever0x.telegram_gpt_bot.model.request.admin.MessageRequest;
import com.sever0x.telegram_gpt_bot.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/admin/send")
    public void sendMessageViaBot(@RequestBody @Valid MessageRequest messageRequest) throws ServiceException {
        adminService.sendCustomMessage(messageRequest.chatId(), messageRequest.message());
    }
}
