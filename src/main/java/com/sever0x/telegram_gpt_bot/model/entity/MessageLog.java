package com.sever0x.telegram_gpt_bot.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String chatId;

    private String senderUsername;

    @Column(columnDefinition = "TEXT")
    private String senderMessage;

    @Column(columnDefinition = "TEXT")
    private String responseMessage;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime time;
}
