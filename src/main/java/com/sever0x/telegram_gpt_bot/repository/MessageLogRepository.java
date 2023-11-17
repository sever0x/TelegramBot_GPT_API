package com.sever0x.telegram_gpt_bot.repository;

import com.sever0x.telegram_gpt_bot.model.entity.MessageLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageLogRepository extends JpaRepository<MessageLog, Long> {
}
