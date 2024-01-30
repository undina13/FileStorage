package ru.undina.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.undina.entity.AppUser;

public interface AppUserDAO extends JpaRepository<AppUser, Long> {
    AppUser findAppUserByTelegramUserId(Long id);
}
