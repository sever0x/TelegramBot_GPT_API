package com.sever0x.telegram_gpt_bot.client;

import com.sever0x.telegram_gpt_bot.exception.ServiceException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GPTClient {

    @Autowired
    private OkHttpClient client;

    @Value("${gpt.api.url}")
    private String url;

    @Value("${gpt.api.token}")
    private String gptToken;

    @Value("${gpt.api.model}")
    private String gptModel;

    public String getGPTResponse(String prompt) throws ServiceException {
        String requestBody = String.format("{\"model\": \"%s\", \"messages\": [{\"role\": \"user\", \"content\": \"%s\"}]}", gptModel, prompt);

        var request = new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + gptToken)
                .post(RequestBody.create(MediaType.parse("application/json"), requestBody))
                .build();

        try (var response = client.newCall(request).execute()) {
            var body = response.body();
            return body == null ? null : body.string();
        } catch (IOException e) {
            throw new ServiceException("An error occurred while accessing GPT", e);
        }
    }
}