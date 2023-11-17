package com.sever0x.telegram_gpt_bot.bot;

import com.sever0x.telegram_gpt_bot.exception.ServiceException;
import com.sever0x.telegram_gpt_bot.service.GPTService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class GoslingBot extends TelegramLongPollingBot {

    private final GPTService gptService;

    @Value("${telegram.bot.username}")
    private String botUsername;

    public GoslingBot(@Value("${telegram.bot.token}") String botToken, GPTService gptService) {
        super(botToken);
        this.gptService = gptService;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            String chatId = update.getMessage().getChatId().toString();

            switch (messageText) {
                case "/start":
                    startCommandReceived(chatId, update.getMessage().getChat().getFirstName());
                    break;
                default:
                    handleUserMessage(chatId, messageText, update.getMessage());
            }
        }
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    private void startCommandReceived(String chatId, String name) {
        String answer = "Привіт, " + name + ", я Райан Гослінг, твій особистий асистент! 😎\n" +
                "Задавай свої питання, і я намагатимусь відповісти так, як найкраще вмію. " +
                "Не гарантую, що буде так само стильно, як у кіно, але я обіцяю розвеселити тебе! 🚀";
        sendTextMessage(chatId, answer);
    }

    private void handleUserMessage(String chatId, String userMessage, Message message) {
        try {
            String gptResponse = gptService.getGPTResponse(message, userMessage);
            sendTextMessage(chatId, gptResponse);
        } catch (ServiceException e) {
            e.printStackTrace();
            sendTextMessage(chatId, "Вибач, виникла помилка при спробі отримати відповідь. Спробуй ще раз");
        }
    }

    private void sendTextMessage(String chatId, String text) {
        try {
            execute(new SendMessage(chatId, text));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
