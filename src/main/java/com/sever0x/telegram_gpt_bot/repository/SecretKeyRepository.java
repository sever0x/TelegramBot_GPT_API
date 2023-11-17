package com.sever0x.telegram_gpt_bot.repository;

import com.sever0x.telegram_gpt_bot.model.entity.SecretKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SecretKeyRepository extends JpaRepository<SecretKey, Integer> {
    Optional<SecretKey> findBySecret(String secret);

    boolean existsBySecret(String secret);
}
