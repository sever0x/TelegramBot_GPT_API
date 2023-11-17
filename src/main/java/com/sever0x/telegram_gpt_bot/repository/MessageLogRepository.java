package com.sever0x.telegram_gpt_bot.repository;

import com.sever0x.telegram_gpt_bot.model.entity.MessageLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageLogRepository extends JpaRepository<MessageLog, Long> {

    List<MessageLog> findByChatId(String chatId);

    List<MessageLog> findBySenderUsername(String senderUsername);

}
